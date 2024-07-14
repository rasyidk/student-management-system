package com.rasyidk.StudentManagementSystem.mapper;


import com.rasyidk.StudentManagementSystem.dto.StudentDTO;
import com.rasyidk.StudentManagementSystem.models.Student;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class StudentMapper {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public StudentDTO toDto(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setNamaDepan(student.getNamaDepan());
        studentDTO.setNamaBelakang(student.getNamaBelakang());
        studentDTO.setTanggalLahir(student.getTanggalLahir());
        studentDTO.setNamaLengkap(student.getNamaDepan() + (student.getNamaDepan() != null ? " " + student.getNamaBelakang() : ""));
        studentDTO.setUsia(LocalDate.now().getYear() - student.getTanggalLahir().getYear());
        return studentDTO;
    }

    public Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setNamaDepan(studentDTO.getNamaDepan());
        student.setNamaBelakang(studentDTO.getNamaBelakang());
        student.setTanggalLahir(studentDTO.getTanggalLahir());
        return student;
    }
}