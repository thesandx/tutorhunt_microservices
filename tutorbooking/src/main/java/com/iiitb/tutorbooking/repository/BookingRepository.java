package com.iiitb.tutorbooking.repository;

import com.iiitb.tutorbooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}


