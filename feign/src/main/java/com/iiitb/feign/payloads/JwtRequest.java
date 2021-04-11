package com.iiitb.feign.payloads;

import javax.validation.constraints.NotBlank;


public class JwtRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String username;
    private String name;

    @NotBlank
    private String role;


    public JwtRequest(@NotBlank String email, @NotBlank String password, @NotBlank String username, String name, String role) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.name = name;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
