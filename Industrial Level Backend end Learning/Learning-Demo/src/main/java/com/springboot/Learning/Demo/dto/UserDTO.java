package com.springboot.Learning.Demo.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    private String email;
}
