package com.guilhermekellermann.programming_course.modules.course;

public enum Category {
    BACK_END("Back-end"),
    FRONT_END("Front-end"),
    FULLSTACK("Fullstack"),
    DEVOPS("DevOps");

    private final String descricao;

    Category(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
