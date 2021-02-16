package com.iiitb.feign.contollers;

import com.iiitb.feign.clients.RestClient;
import com.iiitb.feign.payloads.JwtRequest;
import com.iiitb.feign.payloads.TutorList;
import com.iiitb.feign.payloads.tutorrequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

//    @PostMapping("/courses")
//    public ResponseEntity<String> courseRegister(@RequestBody courserequest creq){
//        return restClient.CourseRegister(creq);
//    }

    @PostMapping("/tutor")
    public ResponseEntity<String> tutorRegister(@RequestBody tutorrequest treq){
        return restClient.TutorRegistration(treq);
    }
    @GetMapping("/hello")
    public String hello(){
        return restClient.firstPage();
    }

    @PostMapping("/tutorlist")
    public ResponseEntity<List<?>> tutorRegister(@RequestBody TutorList tutor){
        return restClient.TutorList(tutor);
    }

    @GetMapping("/allcourses")
    public List<String> getAllCourses() {
        return restClient.getAllCourses();

    }
}
