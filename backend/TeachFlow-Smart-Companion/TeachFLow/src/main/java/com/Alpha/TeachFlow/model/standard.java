package com.Alpha.TeachFlow.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class standard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary Key

    @NotBlank
    private String standardName;


    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    @JsonBackReference
    private School school;
}
