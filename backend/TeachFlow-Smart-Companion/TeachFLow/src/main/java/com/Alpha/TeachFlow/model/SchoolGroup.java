package com.Alpha.TeachFlow.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SchoolGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    private String groupName;  // Example field
}
