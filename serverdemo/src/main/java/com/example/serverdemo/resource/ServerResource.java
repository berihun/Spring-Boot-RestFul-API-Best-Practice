package com.example.serverdemo.resource;

import com.example.serverdemo.model.Response;
import com.example.serverdemo.model.Serverr;
import com.example.serverdemo.service.implementation.ServerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static com.example.serverdemo.enumeration.Status.SERVER_UP;
import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

//import java.nio.file.Path;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/server")
//@RequiredArgsConstructor
public class ServerResource {
    private ServerServiceImpl serverService;

    @Autowired
    public ServerResource(ServerServiceImpl serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/list")
    public ResponseEntity<Response> getServers() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(3);
//        throw new InterruptedException("something went wrong");
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("Servers", serverService.list(30)))
                        .message(String.valueOf(OK))
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/ping/{ipAddress}")
    public ResponseEntity<Response> pingServer(@PathVariable("ipAddress") String ipAddress) throws IOException {
        Serverr serverr = serverService.ping(ipAddress);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("server", serverr))
                        .message(serverr.getStatus() == SERVER_UP ? "Ping success" : "Ping failed")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> pingServer(@RequestBody @Valid Serverr serverr) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("server", serverService.create(serverr)))
                        .message("Server created!")
                        .status(CREATED)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @GetMapping("/get/{ipAddress}")
    public ResponseEntity<Response> getServer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("server", serverService.get(id)))
                        .message("Server retrieved!")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteServer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", serverService.delete(id)))
                        .message("Server deleted!")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getServerImage(@PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/Downloads/images" + fileName));
    }
}
