package com.iiitb.feign.contollers;

import com.iiitb.feign.clients.BookingClient;
import com.iiitb.feign.clients.RestClient;
import com.iiitb.feign.payloads.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HomeController {

    final RestClient restClient;
    final BookingClient bookingclient;

    @Autowired
    public HomeController(RestClient restClient, BookingClient bookingclient) {
        this.restClient = restClient;
        this.bookingclient = bookingclient;
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody JwtRequest authenticationRequest) {
        return restClient.createAuthenticationToken(authenticationRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest authenticationRequest) {
        return restClient.checkAuthenticationToken(authenticationRequest);
    }

//    @PostMapping("/courses")
//    public ResponseEntity<String> courseRegister(@RequestBody courserequest creq){
//        return restClient.CourseRegister(creq);
//    }

    @PostMapping("/tutor")
    public ResponseEntity<String> tutorRegister(@RequestBody tutorrequest treq) {
        return restClient.TutorRegistration(treq);
    }

    @GetMapping("/hello")
    public String hello() {
        return restClient.firstPage();
    }

    @PostMapping("/tutorlist")
    public ResponseEntity<List<?>> tutorRegister(@RequestBody TutorList tutor) {
        return restClient.TutorList(tutor);
    }

    @GetMapping("/allcourses")
    public List<String> getAllCourses() {
        return restClient.getAllCourses();

    }

    @PostMapping("/courseobjective")
    public ResponseEntity<?> getCourseObj(@RequestBody getobjectiverequest gor) {
//        System.out.println("I am get objective");
        return restClient.getCourseObj(gor);

    }

    @PostMapping("/showTimeSlots")
    public List<String> showBooking(@RequestBody BookingRequest bookingRequest) {
        return bookingclient.showBooking(bookingRequest);
    }

    @PostMapping("/BookTimeSlots")
    public ResponseEntity<?> bookslot(@RequestBody bookslotrequest bookslot) {
        return bookingclient.bookslot(bookslot);
    }

    @PostMapping("/showSchedule")
    public ResponseEntity<?> showschedule(@RequestBody showtutorrequest str) {
        return bookingclient.showschedule(str);
    }

    @PostMapping("/showstudents")
    public ResponseEntity<?> showstudents(@RequestBody showstudentrequest ssr) {
        return bookingclient.showstudents(ssr);
    }

}
