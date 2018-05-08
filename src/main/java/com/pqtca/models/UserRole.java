package com.pqtca.models;

import com.pqtca.repos.UserRoles;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_roles")
public class UserRole {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "role")
    private String role;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
