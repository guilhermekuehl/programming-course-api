package com.guilhermekellermann.programming_course.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermekellermann.programming_course.exceptions.CourseNotFoundException;
import com.guilhermekellermann.programming_course.modules.course.CourseEntity;
import com.guilhermekellermann.programming_course.modules.course.CourseRepository;

@Service
public class UpdateCourseUseCase {

    @Autowired
    public CourseRepository courseRepository;
    
    public CourseEntity execute(UUID courseId, CourseEntity oldCourse) {
        var course = this.courseRepository.findById(courseId).orElseThrow(() -> {
            throw new CourseNotFoundException();
        });

        var category = oldCourse.getCategory();
        var name = oldCourse.getName();

        if (category != null) {
            course.setCategory(category);
        }

        if (name != null) {
            course.setName(name);
        }

        return this.courseRepository.save(course);
    }
}
