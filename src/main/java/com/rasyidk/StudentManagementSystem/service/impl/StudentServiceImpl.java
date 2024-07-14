package com.rasyidk.StudentManagementSystem.service.impl;



import com.rasyidk.StudentManagementSystem.dto.StudentDTO;
import com.rasyidk.StudentManagementSystem.mapper.StudentMapper;
import com.rasyidk.StudentManagementSystem.models.Student;
import com.rasyidk.StudentManagementSystem.repository.StudentRepository;
import com.rasyidk.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(studentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDTO> getStudentById(Long id) {
        return studentRepository.findById(id).map(studentMapper::toDto);
    }

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
