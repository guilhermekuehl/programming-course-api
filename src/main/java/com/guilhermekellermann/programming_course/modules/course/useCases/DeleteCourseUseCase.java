package com.guilhermekellermann.programming_course.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermekellermann.programming_course.exceptions.CourseNotFoundException;
import com.guilhermekellermann.programming_course.modules.course.CourseRepository;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID courseId) {
        var course = this.courseRepository.findById(courseId).orElseThrow(() -> {
            throw new CourseNotFoundException();
        });

        this.courseRepository.delete(course);
    }
}
