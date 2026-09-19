package com.disasterrelief.dto;
import java.time.LocalDateTime;
import com.disasterrelief.model.*;
import jakarta.validation.constraints.*;
public record EmergencyRequestPayload(@NotBlank String requesterName, @NotBlank String contactNumber, @NotBlank String location, @NotBlank String requestType, @NotBlank @Size(max=2000) String description, @NotNull Priority priority, @Positive int peopleAffected, @NotNull LocalDateTime requestDateTime, @NotNull RequestStatus status) {}
