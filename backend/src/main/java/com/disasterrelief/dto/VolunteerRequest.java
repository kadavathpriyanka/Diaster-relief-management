package com.disasterrelief.dto;
import com.disasterrelief.model.*;
import jakarta.validation.constraints.*;
public record VolunteerRequest(@NotBlank String fullName, @Min(18) @Max(120) int age, @NotNull Gender gender, @NotBlank String phone, @NotBlank @Email String email, @NotBlank String address, @NotBlank String skills, @NotNull VolunteerStatus availability, @NotBlank String emergencyContact) {}
