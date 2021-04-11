package com.iiitb.tutorhunt.Models;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", length = 20, nullable = false)
    private String name;

    @Column(name = "Username", length = 20, nullable = false, unique = true)
    private String username;

    @Column(name = "Password", length = 120, nullable = false)
    private String password;


    @Column(name = "Email", length = 50, nullable = false, unique = true)
    @Email
    private String email;

    @Column(name = "Role", length = 10, nullable = false)
    private String role;


//    @Column(name = "Session_id")
//    private String session_id;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(	name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))


    public User() {
    }

    public User(String name, String username, String password, @Email String email, String role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        //this.session_id = session_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public String getSession_id() {
//        return session_id;
//    }
//
//    public void setSession_id(String session_id) {
//        this.session_id = session_id;
//    }
}
