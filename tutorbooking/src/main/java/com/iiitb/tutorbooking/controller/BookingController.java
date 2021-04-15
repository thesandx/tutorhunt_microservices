package com.iiitb.tutorbooking.controller;

import com.iiitb.tutorbooking.models.Booking;
import com.iiitb.tutorbooking.payloads.BookingRequest;
import com.iiitb.tutorbooking.payloads.bookslotrequest;
import com.iiitb.tutorbooking.payloads.bookslotresponse;
import com.iiitb.tutorbooking.services.BookingServices;
import com.iiitb.tutorbooking.services.SlotbookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingServices bookingServices;

    @Autowired
    private SlotbookingService slotbooking;

    @GetMapping("/hello")
    public String firstpage() {
        return "Hello World";
    }

    @PostMapping("/showSlots")
    public List<String> showBooking(@RequestBody BookingRequest bookingRequest){


       // System.out.println("hit aaya");

        //check if same date has any student
        List<String> availableSlots = new ArrayList<>();
        System.out.println(bookingRequest.getDate());
        System.out.println("TutorId "+bookingRequest.getTutor_id());
        List<String> slots = bookingServices.bookedSlots(bookingRequest.getTutor_id(),bookingRequest.getDate());
        //System.out.print(slots.size());


            try {

                Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(bookingRequest.getDate());
                DateFormat df = new SimpleDateFormat("HH:mm");
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR_OF_DAY, 10);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                //int startDate = cal.get(Calendar.DATE);
                while (cal.get(Calendar.HOUR_OF_DAY) < 18) {

                    if(!slots.contains(df.format(cal.getTime()))){
                        availableSlots.add(df.format(cal.getTime()));
                        //System.out.println(df.format(cal.getTime()));
                    }

                    cal.add(Calendar.MINUTE, 30);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        return availableSlots;

    }

    @PostMapping("/bookslot")
    public ResponseEntity<?> bookslot(@RequestBody bookslotrequest bookslot){

        int tutor_id=bookslot.getTutor_id();
        int student_id=bookslot.getStudent_id();
        String date=bookslot.getDate();
        String time=bookslot.getTime();
        Booking slot=new Booking(student_id,tutor_id,date,time);
        boolean result=slotbooking.SlotBooking(slot);
        if(result){
            System.out.println("hit came");
            return ResponseEntity.ok(new bookslotresponse("booked"));
        }
        else{
            return ResponseEntity.ok(new bookslotresponse("not booked"));
        }
    }


}
