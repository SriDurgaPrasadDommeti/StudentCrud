package com.example.demo.serviceInf;

import java.util.List;

import com.example.demo.dtos.StudentRequestDTO;
import com.example.demo.dtos.StudentResponseDTO;

public interface StudentService {
	StudentResponseDTO createStudent(StudentRequestDTO dto);

    StudentResponseDTO getStudentById(Long id);

    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto);

    String deleteStudent(Long id);

}
