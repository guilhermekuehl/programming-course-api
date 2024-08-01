package com.guilhermekellermann.programming_course.exceptions;

public class CourseFoundException extends RuntimeException {
    public CourseFoundException() {
        super("Course already exists.");
    }
}
