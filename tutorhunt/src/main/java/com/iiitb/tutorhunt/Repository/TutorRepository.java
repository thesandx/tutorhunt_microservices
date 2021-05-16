package com.iiitb.tutorhunt.Repository;

import com.iiitb.tutorhunt.Models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {

    Tutor findTutorByTutorid(Long tutorid);
    @Modifying
    @Query("update Tutor t set t.age = :age,t.fee = :fee, t.qualification = :qualification,t.name=:name," +
            "t.gender = :gender where t.tutorid = :tutorid ")
    int fetchUpdatedTutor(@Param("age") int age,@Param("gender") String gender,
                                  @Param("qualification") String qualification,
                                  @Param("fee") double fee,@Param("name") String name,@Param("tutorid") Long tutorid);
}
