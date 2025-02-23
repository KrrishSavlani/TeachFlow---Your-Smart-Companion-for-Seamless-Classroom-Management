package com.Alpha.TeachFlow.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary Key

    @NotBlank
    private String groupName;  // Example: A, B, C, etc.

    // Many groups belong to one school
    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    @JsonBackReference
    private School school;
}
