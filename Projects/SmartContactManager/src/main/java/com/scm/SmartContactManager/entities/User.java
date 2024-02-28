package com.scm.SmartContactManager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    private String enabled;
    private String imageUrl;
    @Column(length =500)

    private String about;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy ="user" )
    private List<Contact> contacts=new ArrayList<>();
}
