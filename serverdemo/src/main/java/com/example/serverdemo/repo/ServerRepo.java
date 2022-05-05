package com.example.serverdemo.repo;

import com.example.serverdemo.model.Serverr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Serverr, Long> {
    Serverr findByIpAddress(String ipAddress);
}
