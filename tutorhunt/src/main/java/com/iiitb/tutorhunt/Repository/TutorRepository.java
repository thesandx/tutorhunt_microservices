package com.iiitb.tutorhunt.Repository;

import com.iiitb.tutorhunt.Models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
