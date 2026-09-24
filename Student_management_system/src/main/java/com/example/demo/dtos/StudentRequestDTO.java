package com.example.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentRequestDTO {
	 
    
    private String name;

     
    @Email(message = "Email must be valid")
    @Size(max = 100)
    private String email;

    @Size(max = 15)
    private String phone;

    @Min(value = 1, message = "Age must be positive")
    private Integer age;

    private String gender;

    @Size(max = 100)
    private String course;

    private String department;

    private Integer yearOfStudy;

    private String address;

    private Boolean isActive;

}
