package com.iiitb.tutorhunt.payloads;
import java.io.Serializable;


public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private String jwttoken;
    private String name;
    private String email;
    private String role;
    private String username;
    private Long id;


    public JwtResponse(String jwttoken) {

        this.jwttoken = jwttoken;
      //  this.email=email;
    }




    public JwtResponse(String jwttoken, String name, String email, String role, String username, Long id) {
    this.jwttoken = jwttoken;
    this.name = name;
    this.email = email;
    this.role = role;
    this.username = username;
    this.id=id;
}



    public String getJwttoken() {
        return jwttoken;
    }

    public void setJwttoken(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

