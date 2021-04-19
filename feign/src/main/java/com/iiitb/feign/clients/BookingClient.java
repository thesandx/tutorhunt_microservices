package com.iiitb.feign.clients;

import com.iiitb.feign.payloads.BookingRequest;
import com.iiitb.feign.payloads.bookslotrequest;
import com.iiitb.feign.payloads.showstudentrequest;
import com.iiitb.feign.payloads.showtutorrequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="tutorbooking")
public interface BookingClient {

    @RequestMapping(method = RequestMethod.POST, value="/showSlots")
    List<String> showBooking(@RequestBody BookingRequest bookingRequest);

    @RequestMapping(method = RequestMethod.POST, value="/bookslot")
    ResponseEntity<?> bookslot(@RequestBody bookslotrequest bookslot);

    @RequestMapping(method=RequestMethod.POST, value="/showSchedule")
    ResponseEntity<?> showschedule(@RequestBody showtutorrequest str);

    @RequestMapping(method=RequestMethod.POST, value="/showstudents")
    ResponseEntity<?> showstudents(@RequestBody showstudentrequest ssr);

    }
