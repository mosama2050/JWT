package com.example.authentication.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.validation.constraints.Size;
@Entity
@Table(name = "users")
@Data
public class Users   implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;



    @Column(name = "user_name")
    private String username;



    @Column(name = "password")
    private String password;


    @Column(name = "enabled")
    private int enabled;

    @Column(name = "first_name")
    private String firstName;



    @Column(name = "last_name")
    private String lastName;
}