package com.iiitb.tutorhunt.Repository;

import com.iiitb.tutorhunt.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
