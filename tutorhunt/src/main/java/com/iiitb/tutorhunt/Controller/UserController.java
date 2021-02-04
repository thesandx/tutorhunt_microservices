package com.iiitb.tutorhunt.Controller;

import com.iiitb.tutorhunt.Services.loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.iiitb.tutorhunt.payloads.jwtutil;
import com.iiitb.tutorhunt.payloads.JwtRequest;
import com.iiitb.tutorhunt.payloads.JwtResponse;

import java.util.ArrayList;


@RestController
@CrossOrigin
@RequestMapping(value = "/api", method = RequestMethod.POST)
public class UserController {

    @Autowired
    private jwtutil jwtTokenUtil;

    @Autowired
    private loginservice userDetailsService;


    @PostMapping("/student_signup")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)  {


        String uname=authenticationRequest.getUsername();
        String pwd=authenticationRequest.getPassword();
        String email = authenticationRequest.getEmail();
        System.out.println("email mila hai "+email);
        String name = authenticationRequest.getName();
        //check if exixtes

        com.iiitb.tutorhunt.Models.User user  = userDetailsService.findByUsername(uname);
        if(user!=null){
            System.out.println("user already exists");
            final String token="T";
            return ResponseEntity.ok(new JwtResponse(token));
        }

        //generate new token
        UserDetails userDetails = new User(uname,pwd,new ArrayList<>());
        final String token = jwtTokenUtil.generateToken(userDetails);

        com.iiitb.tutorhunt.Models.User student = new com.iiitb.tutorhunt.Models.User(name,uname,pwd,email,token);

        boolean result = userDetailsService.registerUser(student);
        if(result) {
            return ResponseEntity.ok(new JwtResponse(token));
        }
        else{
            System.out.println("something went wrong");
            final String token1="T";
            return ResponseEntity.ok(new JwtResponse(token1));
        }
    }


    @PostMapping("/student_login")
    public ResponseEntity<?> checkAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {
        System.out.println("login ke under aaya");
//        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        String uname=authenticationRequest.getUsername();
        String pwd=authenticationRequest.getPassword();





        com.iiitb.tutorhunt.Models.User user = userDetailsService.checkcredentials(uname,pwd);

        if(user!=null){
            System.out.println("Successfull....");

            final UserDetails userDetails = userDetailsService.loadUserByUsername(uname);
            final String token = jwtTokenUtil.generateToken(userDetails);

            //save new token in db
            user.setSession_id(token);
            boolean result = userDetailsService.registerUser(user);
            if(result) {
                return ResponseEntity.ok(new JwtResponse(token,user.getName(),user.getEmail(),"student",user.getUsername()));
            }
            else{
                System.out.println("FAILURE while updating token");
                return ResponseEntity.ok(new JwtResponse("T"));
            }
            //final User user=userDetailsService.findByUsername(authenticationRequest.getUsername());

        }
      //  System.out.println(userDetails.getPassword());
        else{
            System.out.println("FAILURE,incorect password");
            final String token="T";
            return ResponseEntity.ok(new JwtResponse(token));

        }


    }

//    private void authenticate(String username, String password) throws Exception {
//
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//
//        }
//
//    }

}