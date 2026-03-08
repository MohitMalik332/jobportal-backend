package com.mohit.jobportal.dto;

import lombok.Data;

@Data
public class RegisterRequestDTO {

	private String fullName;
    private String email;
    private String password;
}
