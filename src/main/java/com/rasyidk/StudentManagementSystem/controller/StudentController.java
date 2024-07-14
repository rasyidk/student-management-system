package com.rasyidk.StudentManagementSystem.controller;



import com.rasyidk.StudentManagementSystem.dto.StudentDTO;
import com.rasyidk.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "add_student";
    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") StudentDTO studentDTO, RedirectAttributes redirectAttributes) {
        studentService.saveStudent(studentDTO);
        redirectAttributes.addAttribute("success", "true");
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id).orElse(null));
        return "edit_student";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") StudentDTO studentDTO) {
        studentDTO.setId(id);
        studentService.saveStudent(studentDTO);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
