package com.Alpha.TeachFlow.Repository;

import com.Alpha.TeachFlow.model.medium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediumRepo extends JpaRepository<medium, Long> {

    // Find all mediums by school ID
    List<medium> findBySchool_Id(Long schoolId);  // Corrected

    // Find medium by name
    List<medium> findByMediumName(String mediumName);
}
