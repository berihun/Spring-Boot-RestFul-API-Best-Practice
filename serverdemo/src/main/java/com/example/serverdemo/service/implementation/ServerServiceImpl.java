package com.example.serverdemo.service.implementation;

import com.example.serverdemo.enumeration.Status;
import com.example.serverdemo.model.Serverr;
import com.example.serverdemo.repo.ServerRepo;
import com.example.serverdemo.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

//@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService {
    private ServerRepo serverRepo;

   @ Autowired
    public ServerServiceImpl(ServerRepo serverRepo) {

       this.serverRepo = serverRepo;
    }

    @Override
    public Serverr create(Serverr serverr) {
        log.info(" Saving new server : {}", serverr.getId());
        serverr.setImageUrl(setServerImageUrl());

        return serverRepo.save(serverr);
    }


    @Override
    public Collection<Serverr> list(int limit) {
        log.info(" Fetching all servers: " + serverRepo.findAll().size());
        return serverRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Serverr get(Long id) {
        log.info(" Fetching  server by id :{}", id);
        return serverRepo.findById(id).get();
    }

    @Override
    public Serverr update(Serverr serverr) {
        log.info(" Updating server : {}", serverr.getId());
        return serverRepo.save(serverr);
    }

    @Override
    public Boolean delete(Long id) {
        log.info(" deliting server by ID: {}", id);
        serverRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Serverr ping(String ipAddress) throws IOException {
        log.info("Pinging server ip : {}", ipAddress);
        var serverr = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        serverr.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepo.save(serverr);
        return serverr;
    }

    private String setServerImageUrl() {
        String[] imageName = {"server1.png", "server2.png", "server3.png", "server4.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageName[new Random().nextInt(4)]).toUriString();
    }
}
