package com.iiitb.tutorbooking.controller;

import com.iiitb.tutorbooking.payloads.BookingRequest;
import com.iiitb.tutorbooking.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping({"/booking"})
public class BookingController {

    @Autowired
    private BookingServices bookingServices;

    @PostMapping("/showSlots")
    public List<String> showBooking(@RequestBody BookingRequest bookingRequest){

        //check if same date has any patient
        List<String> avaliableSlots = new ArrayList<>();

        List<String> slots = bookingServices.bookedSlots(bookingRequest.getTutor_id(),bookingRequest.getDate());



            try {
                Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(bookingRequest.getDate());
                DateFormat df = new SimpleDateFormat("HH:mm");
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.HOUR_OF_DAY, 10);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                //int startDate = cal.get(Calendar.DATE);
                while (cal.get(Calendar.HOUR_OF_DAY) < 18) {
                    System.out.println(df.format(cal.getTime()));
                    if(!slots.contains(df.format(cal.getTime()))){
                        avaliableSlots.add(df.format(cal.getTime()));
                    }

                    cal.add(Calendar.MINUTE, 30);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }




        return avaliableSlots;

    }

}
