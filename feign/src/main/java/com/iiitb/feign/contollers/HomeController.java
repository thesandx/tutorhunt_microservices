package com.iiitb.feign.contollers;

import com.iiitb.feign.clients.RestClient;
import com.iiitb.feign.payloads.JwtRequest;
import com.iiitb.feign.payloads.courserequest;
import com.iiitb.feign.payloads.tutorrequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    final RestClient restClient;
    @Autowired
    public HomeController(RestClient restClient){
        this.restClient = restClient;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody JwtRequest authenticationRequest){
        return restClient.createAuthenticationToken(authenticationRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest authenticationRequest){
        return restClient.checkAuthenticationToken(authenticationRequest);
    }

    @PostMapping("/courses")
    public ResponseEntity<String> courseRegister(@RequestBody courserequest creq){
        return restClient.CourseRegister(creq);
    }

    @PostMapping("/tutor")
    public ResponseEntity<String> tutorRegister(@RequestBody tutorrequest treq){
        return restClient.TutorRegistration(treq);
    }
    @GetMapping("/hello")
    public String hello(){
        return restClient.firstPage();
    }




}
