package com.Alpha.TeachFlow.Repository;

import com.Alpha.TeachFlow.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepo extends JpaRepository<School, Long> {

    // Find school by schoolCode
    Optional<School> findBySchoolCode(String schoolCode);

    // Find school by email
    Optional<School> findByEmail(String email);

    // Find all schools with pending approval
    Optional<School> findByRequestApproval(Boolean requestApproval);
}
