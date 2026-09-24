package com.example.demo.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({
    "id",
    "name",
    "email",
    "phone",
    "age",
    "gender",
    "course",
    "department",
    "yearOfStudy",
    "address",
    "isActive",
    "createdAt",
    "updatedAt"
})
public class StudentResponseDTO {
	private Long id;
    private String name;
    private String email;
    private String phone;
    private Integer age;
    private String gender;
    private String course;
    private String department;
    private Integer yearOfStudy;
    private String address;
    private Boolean isActive;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime updatedAt;

}
