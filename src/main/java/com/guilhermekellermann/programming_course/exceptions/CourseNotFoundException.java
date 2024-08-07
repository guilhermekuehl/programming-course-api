package com.guilhermekellermann.programming_course.exceptions;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException() {
        super("Course not found.");
    }
}
