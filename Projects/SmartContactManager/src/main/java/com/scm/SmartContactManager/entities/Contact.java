package com.scm.SmartContactManager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cId;
    private String name;
    private String nickName;
    private String work;
    private String email;
    private String phone;
    private String image;
    @Column(length = 1000)
    private String description;
    @ManyToOne
    private User user;

}
