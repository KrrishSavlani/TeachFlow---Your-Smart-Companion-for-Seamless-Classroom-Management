package com.Alpha.TeachFlow.Repository;

import com.Alpha.TeachFlow.model.SchoolGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepo extends JpaRepository<SchoolGroup, Long> {


    List<SchoolGroup> findBySchoolRequestId(Long schoolId);


    List<SchoolGroup> findByGroupName(String groupName);
}
