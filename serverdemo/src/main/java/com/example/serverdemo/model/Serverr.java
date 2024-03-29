package com.example.serverdemo.model;

import com.example.serverdemo.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data public class Serverr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Ip Address cannot be empty or null")
    private String ipAddress;
    private String name;
    private String memory;
    private     String type;
    private String imageUrl;
    private Status status;

}
