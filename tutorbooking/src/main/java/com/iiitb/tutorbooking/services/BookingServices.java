package com.iiitb.tutorbooking.services;

import com.iiitb.tutorbooking.models.Booking;
import com.iiitb.tutorbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServices {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBooking(){

        return bookingRepository.findAll();

    }


    public List<String> bookedSlots(int tutor_id,String date){
        List<String> bookedTimes = new ArrayList<>();
        List<Booking> allBookings = getAllBooking();

        for(Booking booking : allBookings){
            if(booking.getTutor_id()==tutor_id){
                if(booking.getDate().equalsIgnoreCase(date)){
                    bookedTimes.add(booking.getTime());
                }
            }
        }
        return bookedTimes;
    }

}
