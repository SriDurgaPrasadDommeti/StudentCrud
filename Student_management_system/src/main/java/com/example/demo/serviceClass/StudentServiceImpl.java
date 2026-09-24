package com.example.demo.serviceClass;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.StudentRequestDTO;
import com.example.demo.dtos.StudentResponseDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.serviceInf.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
	private final ModelMapper modelMapper;
	private final StudentRepository studentRepository;
	
	@Override
	public StudentResponseDTO createStudent(StudentRequestDTO dto) {
		Student student=modelMapper.map(dto, Student.class);
		student.setIsActive(true);
		Student studentsave=studentRepository.save(student);
		return modelMapper.map(studentsave, StudentResponseDTO.class);
	}
	@Override
	public StudentResponseDTO getStudentById(Long id) {
		Student student=studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student ot Found"+id));
		return modelMapper.map(student, StudentResponseDTO.class);
	}
	@Override
	public List<StudentResponseDTO> getAllStudents() {
		return studentRepository.findAll().stream().map(student->modelMapper.map(student, StudentResponseDTO.class)).collect(Collectors.toList());
	}
	@Override
	public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
		Student student=studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found with id "+id));
		modelMapper.map(dto, student);
		Student updatedstudent=studentRepository.save(student);
		return modelMapper.map(updatedstudent, StudentResponseDTO.class);
	}
	@Override
	public String deleteStudent(Long id) {
		Student student=studentRepository.findById(id).orElseThrow(()->new RuntimeException("student not found with id "+id));
		if(student.getIsActive()==null ||student.getIsActive()==false) {
			studentRepository.delete(student);
			return "Student deleted Successfully";
		}else {
			return "Student is Active cannot be deleted";
		}
	}
	

}
