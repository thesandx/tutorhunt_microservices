package com.iiitb.tutorbooking.services;

import com.iiitb.tutorbooking.DTO.UserBooking;
import com.iiitb.tutorbooking.models.Booking;
import com.iiitb.tutorbooking.repository.BookingRepository;
import com.iiitb.tutorbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class showstudentservice {

    @Autowired
    private BookingRepository bookrepo;
    @Autowired
    private UserRepository userrepo;

    public List<Booking> AllBooking(){
        return bookrepo.findAll();
    }
    public List<Booking> ShowStudentList(int tutorid){
        List<Booking> bookings=AllBooking();
        List<Booking> result = new ArrayList<>();
        for(Booking b: bookings){
            if(b.getTutor_id()==tutorid){
                result.add(b);
            }
        }
        return result;
    }

    public List<UserBooking> getUserBookingInnerJoin(int tutorid) {
        List<UserBooking> list = userrepo.fetchUserBooking(tutorid);
        for(UserBooking l:list){
            System.out.println(l.getName()+"\n"+l.getDate());
        }
        return list;
    }


}
