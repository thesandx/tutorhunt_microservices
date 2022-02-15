package com.iiitb.tutorbooking.services;

import com.iiitb.tutorbooking.models.Booking;
import com.iiitb.tutorbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlotbookingService {

    @Autowired
    private BookingRepository bookrepo;

    public boolean SlotBooking(Booking bookslot){
        try{
            bookrepo.save(bookslot);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return false;
        }

    }
}
