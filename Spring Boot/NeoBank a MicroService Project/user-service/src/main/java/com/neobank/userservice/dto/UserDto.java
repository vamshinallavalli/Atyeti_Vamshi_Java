package com.neobank.userservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object for User")
public class UserDto {

    @NotBlank(message = "Full name is required")
    @Schema(description = "Full name of the user", example = "John Doe", required = true)
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Schema(description = "Email address of the user", example = "john.doe@example.com", required = true)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Schema(description = "Password of the user", example = "Secret123", required = true)
    private String password;

    @NotBlank(message = "Phone number is required")
    @Schema(description = "Phone number of the user", example = "9876543210", required = true)
    private String phone;
}