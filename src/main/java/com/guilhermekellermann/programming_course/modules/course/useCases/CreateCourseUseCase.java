package com.guilhermekellermann.programming_course.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermekellermann.programming_course.exceptions.CourseFoundException;
import com.guilhermekellermann.programming_course.modules.course.CourseEntity;
import com.guilhermekellermann.programming_course.modules.course.CourseRepository;

@Service
public class CreateCourseUseCase {
    
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity) {
        this.courseRepository.findByName(courseEntity.getName()).ifPresent((course) -> {
            throw new CourseFoundException();
        });

        return this.courseRepository.save(courseEntity);
    }
}
