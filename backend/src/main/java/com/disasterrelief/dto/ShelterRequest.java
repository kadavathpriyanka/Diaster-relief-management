package com.disasterrelief.dto;
import com.disasterrelief.model.ShelterStatus;
import jakarta.validation.constraints.*;
public record ShelterRequest(@NotBlank String name, @NotBlank String location, @Positive int capacity, @PositiveOrZero int currentOccupancy, @NotBlank String contactPerson, @NotBlank String contactNumber, @NotNull ShelterStatus status) {}
