package com.guilhermekellermann.programming_course.modules.course;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ECategory {
    BACK_END("Back-end"),
    FRONT_END("Front-end"),
    FULLSTACK("Fullstack"),
    DEVOPS("DevOps");

    private final String descricao;

    ECategory(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static boolean contains(ECategory value) {
        for (ECategory category : ECategory.values()) {
            if (category.equals(value)) {
                return true;
            }
        }

        return false;
    }
}
