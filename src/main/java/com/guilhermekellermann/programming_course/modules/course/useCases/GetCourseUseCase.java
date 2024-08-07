package com.guilhermekellermann.programming_course.modules.course.useCases;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermekellermann.programming_course.exceptions.CourseNotFoundException;
import com.guilhermekellermann.programming_course.modules.course.ECategory;
import com.guilhermekellermann.programming_course.modules.course.CourseEntity;
import com.guilhermekellermann.programming_course.modules.course.CourseRepository;
import com.guilhermekellermann.programming_course.modules.course.dto.CourseResponseDTO;

@Service
public class GetCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseResponseDTO execute(String name, ECategory category) {
        var course = this.courseRepository.findByNameOrCategory(name, category).orElseThrow(() -> {
            throw new CourseNotFoundException();
        });

        var courseDTO = CourseResponseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .category(course.getCategory().getDescricao())
                .active(course.isActive())
                .build();

        return courseDTO;
    }

    public CourseResponseDTO execute(String name) {
        var course = this.courseRepository.findByName(name).orElseThrow(() -> {
            throw new CourseNotFoundException();
        });

        var courseDTO = CourseResponseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .category(course.getCategory().getDescricao())
                .active(course.isActive())
                .build();

        return courseDTO;
    }

    public List<CourseResponseDTO> execute() {
        var courses = this.courseRepository.findAll();
        if (courses.isEmpty() || courses == null) {
            throw new CourseNotFoundException();
        }

        List<CourseResponseDTO> courseResponseDTOList = new ArrayList<>();
        var courseDTO = CourseResponseDTO.builder();

        for (CourseEntity course : courses) {
            courseResponseDTOList.add(courseDTO.id(course.getId())
                    .name(course.getName())
                    .category(course.getCategory().getDescricao())
                    .active(course.isActive())
                    .build());
        }

        return courseResponseDTOList;
    }
}
