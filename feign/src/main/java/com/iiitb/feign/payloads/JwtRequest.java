package com.iiitb.feign.payloads;

import javax.validation.constraints.NotBlank;


public class JwtRequest {

    @NotBlank
    private String Email;

    @NotBlank
    private String password;

    @NotBlank
    private String username;

    @NotBlank
    private String name;

    @NotBlank
    private String Role;



    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getRole() { return Role; }

    public void setRole(String role) { this.Role = role; }
}
