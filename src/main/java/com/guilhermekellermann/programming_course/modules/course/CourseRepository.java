package com.guilhermekellermann.programming_course.modules.course;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID>{
    Optional<CourseEntity> findByName(String name);
}
