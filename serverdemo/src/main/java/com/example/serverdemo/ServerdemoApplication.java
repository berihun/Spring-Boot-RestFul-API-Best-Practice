package com.example.serverdemo;

import com.example.serverdemo.model.Serverr;
import com.example.serverdemo.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.serverdemo.enumeration.Status.SERVER_DOWN;
import static com.example.serverdemo.enumeration.Status.SERVER_UP;

@SpringBootApplication
public class ServerdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerdemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServerRepo serverRepo) {
        return args -> {
            serverRepo.save(new Serverr(null, "192.168.1.100", "Ubuntu Linux", "16 GB", "Personal PC",
                    "http://localhost:8080/server/image/server1.png", SERVER_UP));

            serverRepo.save(new Serverr(null, "192.168.1.102", "Ubuntu Linux", "8 GB", "Personal PC",
                    "http://localhost:8080/server/image/server3.png", SERVER_DOWN));
            serverRepo.save(new Serverr(null, "192.168.1.101", "Ubuntu Linux", "32 GB", "Personal PC",
                    "http://localhost:8080/server/image/server2.png", SERVER_UP));
            serverRepo.save(new Serverr(null, "192.168.1.103", "Ubuntu Linux", "12 GB", "Personal PC",
                    "http://localhost:8080/server/image/server4.png", SERVER_DOWN));
        };
    }
}
