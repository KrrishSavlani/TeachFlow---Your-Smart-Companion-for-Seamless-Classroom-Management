package com.Alpha.TeachFlow.Repository;

import com.Alpha.TeachFlow.model.group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepo extends JpaRepository<group, Long> {


    List<group> findBySchoolRequestId(Long schoolId);


    List<group> findByGroupName(String groupName);
}
