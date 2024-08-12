package com.guilhermekellermann.programming_course.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermekellermann.programming_course.exceptions.CourseNotFoundException;
import com.guilhermekellermann.programming_course.modules.course.CourseEntity;
import com.guilhermekellermann.programming_course.modules.course.CourseRepository;

@Service
public class ToggleActiveCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID courseId) {
        var course = this.courseRepository.findById(courseId).orElseThrow(() -> {
            throw new CourseNotFoundException();
        });

        var toggleActive = !course.isActive();

        course.setActive(toggleActive);

        var courseActiveUpdated = this.courseRepository.save(course);

        return courseActiveUpdated;
    }

}
