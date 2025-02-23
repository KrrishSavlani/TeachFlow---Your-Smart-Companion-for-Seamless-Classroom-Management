package com.Alpha.TeachFlow.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String schoolName;

    @NotBlank
    private String schoolCode;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    @Size(min = 6, max = 6, message = "Pincode must be 6 digits")
    @Pattern(regexp = "\\d{6}", message = "Invalid pincode format")
    private String pincode;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Invalid phone number format")
    private String phone;

    @Pattern(regexp = "\\d{10}", message = "Invalid alternate phone number format")
    private String altPhone;

    @NotBlank
    private String principalName;

    @NotBlank
    @Email
    private String adminEmail;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Invalid admin phone number format")
    private String adminPhone;

    @NotBlank
    private String proofDocument;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    private Boolean requestApproval = false;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<standard> standards;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Stream> streams;

    // ✅ Renamed `groups` to `schoolGroups` to prevent conflict with Tomcat's Group class
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<SchoolGroup> schoolGroups;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Subject> subjects;
}
