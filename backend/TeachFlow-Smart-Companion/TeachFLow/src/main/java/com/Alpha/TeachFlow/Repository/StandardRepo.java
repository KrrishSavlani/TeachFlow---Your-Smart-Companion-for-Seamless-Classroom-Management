package com.Alpha.TeachFlow.Repository;

import com.Alpha.TeachFlow.model.standard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandardRepo extends JpaRepository<standard, Long> {

    // Find all standards by school ID
    List<standard> findBySchoolRequestId(Long schoolId);

    // Find standard by name
    List<standard> findByStandardName(String standardName);
}
