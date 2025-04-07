package dev.supervisorback.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class NotificationDto {
    @NotBlank
     String firstName;

    @NotBlank
     String lastName;

    @Email
    @NotBlank
     String email;
}
