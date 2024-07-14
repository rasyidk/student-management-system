package com.rasyidk.StudentManagementSystem.service;

import com.rasyidk.StudentManagementSystem.dto.StudentDTO;
import com.rasyidk.StudentManagementSystem.mapper.StudentMapper;
import com.rasyidk.StudentManagementSystem.models.Student;
import com.rasyidk.StudentManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface StudentService {
    List<StudentDTO> getAllStudents();
    Optional<StudentDTO> getStudentById(Long id);
    StudentDTO saveStudent(StudentDTO studentDTO);
    void deleteStudent(Long id);
}
