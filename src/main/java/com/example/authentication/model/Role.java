package com.example.authentication.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    private long id;
    @Column(name = "role_name")
    private String roleName;
}
