package com.example.server.repo;

import com.example.server.model.Serverr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Serverr, Long> {
    Serverr findByIpAddress(String ipAddress);
}
