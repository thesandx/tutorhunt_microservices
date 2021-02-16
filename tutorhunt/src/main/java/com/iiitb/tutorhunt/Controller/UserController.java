package com.iiitb.tutorhunt.Controller;

import com.iiitb.tutorhunt.Models.Course;
//import com.iiitb.tutorhunt.Services.courseregservice;
import com.iiitb.tutorhunt.Services.loginservice;
import com.iiitb.tutorhunt.payloads.courserequest;
import org.mindrot.jbcrypt.BCrypt;
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

    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtutil jwtTokenUtil;

    @Autowired
    private loginservice userDetailsService;

    public UserController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

    }
    private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    @PostMapping("/signup")
    public ResponseEntity<String> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        String uname=authenticationRequest.getUsername();
        String pwd=authenticationRequest.getPassword();
        pwd=hashPassword(pwd);
        String email = authenticationRequest.getEmail();
        String name = authenticationRequest.getName();
        String role=authenticationRequest.getRole();

        //check if exixtes

        com.iiitb.tutorhunt.Models.User user  = userDetailsService.findByUsername(uname);
        if(user!=null){
            System.out.println("user already exists");
           // final String token="T";
            return ResponseEntity.ok("not registered");
        }


        com.iiitb.tutorhunt.Models.User student = new com.iiitb.tutorhunt.Models.User(name,uname,pwd,email,role);

        boolean result = userDetailsService.registerUser(student);
        if(result) {
            return ResponseEntity.ok("registered");
        }
        else{
            System.out.println("something went wrong");
          //  final String token1="T";
            return ResponseEntity.ok("not registered");
        }
    }


    @PostMapping("/signin")
    public ResponseEntity<?> checkAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        String uname=authenticationRequest.getUsername();
        String pwd=authenticationRequest.getPassword();
        String role=authenticationRequest.getRole();

        //System.out.println(role);

        com.iiitb.tutorhunt.Models.User user = userDetailsService.checkcredentials(uname,pwd,role);

        if(user!=null){
            System.out.println("Successfull....");

            final UserDetails userDetails = userDetailsService.loadUserByUsername(uname);
            final String token = jwtTokenUtil.generateToken(userDetails);

            //save new token in db
//            user.setSession_id(token);
            boolean result = userDetailsService.registerUser(user);
            if(result) {
                return ResponseEntity.ok(new JwtResponse(token,user.getName(),user.getEmail(),user.getRole(),user.getUsername()));
            }
            else{
                System.out.println("FAILURE while updating token");
                return ResponseEntity.ok(new JwtResponse("T"));
            }
            //final User user=userDetailsService.findByUsername(authenticationRequest.getUsername());

        }
      //  System.out.println(userDetails.getPassword());
        else{
            System.out.println("FAILURE,incorect details");
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