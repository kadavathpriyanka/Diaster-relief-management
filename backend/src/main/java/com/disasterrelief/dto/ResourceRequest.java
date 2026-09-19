package com.disasterrelief.dto;
import com.disasterrelief.model.ResourceStatus;
import jakarta.validation.constraints.*;
public record ResourceRequest(@NotBlank String name, @NotBlank String category, @PositiveOrZero int quantity, @NotBlank String unit, String location, @NotNull ResourceStatus status) {}
