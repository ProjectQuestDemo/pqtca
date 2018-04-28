package com.pqtca.demo.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    @NotEmpty
    @Size(min=5, max=45, message = "Username must be minimum 5 characters in length.")
    private String username;
}
