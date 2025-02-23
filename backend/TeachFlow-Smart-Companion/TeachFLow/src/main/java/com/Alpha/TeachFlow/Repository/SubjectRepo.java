package com.Alpha.TeachFlow.Repository;

import com.Alpha.TeachFlow.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {


    List<Subject> findBySchoolRequestId(Long schoolId);


    List<Subject> findBySubjectName(String subjectName);
}
