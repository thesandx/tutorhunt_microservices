package com.iiitb.tutorbooking.repository;

import com.iiitb.tutorbooking.DTO.UserBooking;
import com.iiitb.tutorbooking.models.Booking;
import com.iiitb.tutorbooking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT new com.iiitb.tutorbooking.DTO.UserBooking(u.name, b.date, b.time) FROM User u ,Booking b where u.id=b.student_id and u.role='student' and " +
            "b.tutor_id=:tutor_id")
    //List<UserBooking> fetchUserBooking();
    List<UserBooking> fetchUserBooking(@Param("tutor_id") int tutor_id);
}
