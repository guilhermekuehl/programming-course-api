package com.guilhermekellermann.programming_course.modules.course.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponseDTO {
    
    private UUID id;
    private String name;
    private String category;
    private boolean active;
}
