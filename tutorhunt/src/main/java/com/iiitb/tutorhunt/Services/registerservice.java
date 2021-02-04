package com.iiitb.tutorhunt.Services;

import com.iiitb.tutorhunt.Models.User;
import com.iiitb.tutorhunt.Repository.UserRepository;
import com.iiitb.tutorhunt.payloads.JwtRequest;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class registerservice {

    @Autowired
    private UserRepository repo;

    private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
    public void createdata(JwtRequest data) {
        User user=new User();
        user.setUsername(data.getUsername());
        user.setEmail(data.getEmail());
        String encryptedpass=hashPassword(data.getPassword());
        user.setPassword(encryptedpass);
        user.setName(data.getName());
        repo.save(user);
    }


}

