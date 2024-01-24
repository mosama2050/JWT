package com.example.authentication.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import javax.validation.constraints.Size;
@Entity
@Table(name = "users")
@Data
public class Users   implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



    @Column(name = "user_name")
    private String username;



    @Column(name = "password")
    private String password;


    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "first_name")
    private String firstName;



    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}