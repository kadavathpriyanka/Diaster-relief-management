package com.disasterrelief.dto;
import com.disasterrelief.model.RequestStatus;
import jakarta.validation.constraints.*;
public record StatusUpdateRequest(@NotNull RequestStatus status, @NotBlank String note) {}
