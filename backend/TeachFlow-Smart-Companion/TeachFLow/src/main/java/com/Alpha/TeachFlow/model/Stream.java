package com.Alpha.TeachFlow.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Stream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String streamName;


    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    @JsonBackReference
    private School school;
}
