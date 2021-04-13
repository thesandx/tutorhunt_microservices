package com.iiitb.feign.clients;


import com.iiitb.feign.payloads.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "tutorhunt")
public interface RestClient {


    @RequestMapping("/Hello/hello")
    String firstPage();

    @RequestMapping("/Course/getAllCourses")
    List<String> getAllCourses();

    @RequestMapping(method = RequestMethod.POST,value = "/api/signup")
    ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest);

    @RequestMapping(method = RequestMethod.POST,value ="/api/signin")
    ResponseEntity<?> checkAuthenticationToken(JwtRequest authenticationRequest);

    @RequestMapping(method = RequestMethod.POST,value ="/Tutor/application")
    ResponseEntity<String> TutorRegistration(@RequestBody tutorrequest treq);

    @RequestMapping(method = RequestMethod.POST,value ="/Tutor/tutorlist")
    ResponseEntity<List<?>> TutorList(@RequestBody TutorList tutor);

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST,value="/Course/getCourseObjective")
    ResponseEntity<?> getCourseObj(@RequestBody Bookingrequest book);

}
