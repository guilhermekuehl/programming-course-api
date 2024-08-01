package com.guilhermekellermann.programming_course.modules.course.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.guilhermekellermann.programming_course.modules.course.CourseEntity;

@RestController
@RequestMapping("/cursos")
public class CourseController {
    
    @PostMapping("/")
    public void create(@Valid @RequestBody CourseEntity courseEntity) {


    }
}
