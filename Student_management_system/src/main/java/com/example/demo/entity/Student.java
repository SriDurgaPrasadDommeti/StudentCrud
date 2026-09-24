package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Name is required")
	    @Size(max = 50, message = "Name must not exceed 50 characters")
	    @Column(name = "name", nullable = false, length = 50)
	    private String name;

	    @NotBlank(message = "Email is required")
	    @Email(message = "Email must be valid")
	    @Size(max = 100)
	    @Column(name = "email", nullable = false, unique = true, length = 100)
	    private String email;

	    @Size(max = 15)
	    @Column(name = "phone", length = 15)
	    private String phone;

	    @Min(value = 1, message = "Age must be positive")
	    @Column(name = "age")
	    private Integer age;

	    @Column(name = "gender", length = 10)
	    private String gender;

	    @NotBlank(message = "Course is required")
	    @Size(max = 100)
	    @Column(name = "course", nullable = false, length = 100)
	    private String course;

	    @Column(name = "department", length = 100)
	    private String department;

	    @Column(name = "year_of_study")
	    private Integer yearOfStudy;

	    @Column(name = "address", length = 255)
	    private String address;

	    @Column(name = "is_active")
	    private Boolean isActive;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;

	    @PrePersist
	    protected void onCreate() {
	        createdAt = LocalDateTime.now();
	        updatedAt = LocalDateTime.now();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        updatedAt = LocalDateTime.now();
	    }

}
