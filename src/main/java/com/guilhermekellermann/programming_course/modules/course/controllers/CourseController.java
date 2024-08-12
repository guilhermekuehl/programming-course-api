package com.guilhermekellermann.programming_course.modules.course.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.guilhermekellermann.programming_course.modules.course.ECategory;
import com.guilhermekellermann.programming_course.modules.course.CourseEntity;
import com.guilhermekellermann.programming_course.modules.course.useCases.CreateCourseUseCase;
import com.guilhermekellermann.programming_course.modules.course.useCases.DeleteCourseUseCase;
import com.guilhermekellermann.programming_course.modules.course.useCases.GetCourseUseCase;
import com.guilhermekellermann.programming_course.modules.course.useCases.UpdateCourseUseCase;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private GetCourseUseCase getCourseUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            var courseCreated = this.createCourseUseCase.execute(courseEntity);
            return ResponseEntity.ok().body(courseCreated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> get(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "category", required = false) String category) {

        try {
            if ((name != null) && (category == null || category.isEmpty())) {
                var course = this.getCourseUseCase.execute(name);
                return ResponseEntity.ok().body(course);
            } else if (name != null && (category != null && !category.isEmpty())) {
                var course = this.getCourseUseCase.execute(name, ECategory.valueOf(category.toUpperCase()));
                return ResponseEntity.ok().body(course);
            } else {
                var course = this.getCourseUseCase.execute();
                return ResponseEntity.ok().body(course);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> put(@PathVariable UUID id, @Valid @RequestBody CourseEntity oldCourse) {
        try {
            var updatedCourse = this.updateCourseUseCase.execute(id, oldCourse);
            return ResponseEntity.ok().body(updatedCourse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            this.deleteCourseUseCase.execute(id);
            return ResponseEntity.ok().body("Course successfully deleted.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
