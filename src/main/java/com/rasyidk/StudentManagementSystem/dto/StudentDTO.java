package com.rasyidk.StudentManagementSystem.dto;


import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;



@Data
public class StudentDTO {
    private Long id;
    private String namaDepan;
    private String namaBelakang;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggalLahir;
    private String namaLengkap;
    private int usia;
}