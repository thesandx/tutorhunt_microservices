package com.iiitb.tutorhunt.Controller;


import com.iiitb.tutorhunt.Services.registerservice;
import com.iiitb.tutorhunt.payloads.JwtRequest;
import com.iiitb.tutorhunt.payloads.JwtResponse;
import com.iiitb.tutorhunt.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/register",method = RequestMethod.POST)
public class RegistrationController {

    @Autowired
    private registerservice register;
    @PostMapping
    public ResponseEntity<String> registeruser(@RequestBody JwtRequest request){

        register.createdata(request);
        return ResponseEntity.ok("registered");
    }
}
