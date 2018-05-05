package com.pqtca.models;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    @Column(name= "user_name" ,nullable = false, unique = true, length = 45)
    private String username;

    @Column(name ="first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name ="last_name", nullable = false, length = 45)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String username, String firstName, String lastName, String email, String password, Role role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public User(User copy) {
        this.id = copy.id;
        this.email = copy.email;
        this.username = copy.username;
        this.firstName = copy.firstName;
        this.lastName= copy.lastName;
        this.password = copy.password;
        this.role = copy.role;
    }

    public class UserCreateForm {

        @NotEmpty
        private String email = "";

        @NotEmpty
        private String password = "";

        @NotEmpty
        private String passwordRepeated = "";

        @NotNull
        private Role role = Role.USER;

    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public enum Role {
        USER, ADMIN
    }
}
