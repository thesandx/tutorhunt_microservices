package com.iiitb.feign.clients;


import com.iiitb.feign.payloads.JwtRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("tutorhunt")
public interface RestClient {


    @RequestMapping("/Hello/hello")
    String firstPage();

    @RequestMapping(method = RequestMethod.POST,value = "/api/studnet_signup")
    ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest);

    @RequestMapping(method = RequestMethod.POST,value ="/api/student_login")
    ResponseEntity<?> checkAuthenticationToken(@RequestBody JwtRequest authenticationRequest);



}
