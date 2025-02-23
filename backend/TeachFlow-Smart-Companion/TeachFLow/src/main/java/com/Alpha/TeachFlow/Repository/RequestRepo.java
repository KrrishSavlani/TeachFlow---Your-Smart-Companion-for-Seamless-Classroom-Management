package com.Alpha.TeachFlow.Repository;

import com.Alpha.TeachFlow.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestRepo extends JpaRepository<Request, Long> {
    Optional<Request> findBySchoolCode(String schoolCode);
    Optional<Request> findByRequestApproval(Boolean requestApproval);
}
