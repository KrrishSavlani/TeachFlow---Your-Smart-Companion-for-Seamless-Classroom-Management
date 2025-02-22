package com.Alpha.TeachFlow.Repository;

import com.Alpha.TeachFlow.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepo extends JpaRepository<School, Long> {


    Optional<School> findBySchoolCode(String schoolCode);


    Optional<School> findByEmail(String email);


    Optional<School> findByRequestApproval(Boolean requestApproval);
}
