package com.rasyidk.StudentManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @GetMapping
    public String showContactPage() {
        return "contact";
    }

    @PostMapping
    public String handleContactForm(@RequestParam("name") String name,
                                    @RequestParam("email") String email,
                                    @RequestParam("message") String message) {
        return "redirect:/contact?success";
    }
}
