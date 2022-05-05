package com.example.serverdemo.service;

import com.example.serverdemo.model.Serverr;

import java.io.IOException;
import java.util.Collection;

public interface ServerService {
    Serverr create(Serverr serverr);

    Collection<Serverr> list(int limit);

    Serverr get(Long id);

    Serverr update(Serverr serverr);

    Boolean delete(Long id);

    Serverr ping(String ipAddress) throws IOException;
}
