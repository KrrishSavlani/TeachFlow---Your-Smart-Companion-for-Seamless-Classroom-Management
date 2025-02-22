package com.Alpha.TeachFlow.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class medium {


    class Medium {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;  // Primary Key

        @NotBlank
        private String mediumName;  // Example: English, Hindi, etc.

        // Many mediums belong to one school
        @ManyToOne
        @JoinColumn(name = "school_id", nullable = false)
        @JsonBackReference
        private School school;
    }
}
