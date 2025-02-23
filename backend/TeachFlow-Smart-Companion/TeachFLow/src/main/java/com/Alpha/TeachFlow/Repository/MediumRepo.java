package com.Alpha.TeachFlow.Repository;

import com.Alpha.TeachFlow.model.medium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediumRepo extends JpaRepository<medium, Long> {


    List<medium> findBySchool_Id(Long schoolId);


    List<medium> findByMediumName(String mediumName);
}
