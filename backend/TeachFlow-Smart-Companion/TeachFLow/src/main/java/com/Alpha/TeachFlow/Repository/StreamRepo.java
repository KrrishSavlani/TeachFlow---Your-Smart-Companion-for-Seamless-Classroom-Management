package com.Alpha.TeachFlow.Repository;

import com.Alpha.TeachFlow.model.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreamRepo extends JpaRepository<Stream, Long> {

    // Find all streams by school ID
    List<Stream> findBySchoolRequestId(Long schoolId);

    // Find stream by name
    List<Stream> findByStreamName(String streamName);
}
