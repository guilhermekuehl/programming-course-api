package com.guilhermekellermann.programming_course.modules.course;

public enum Category {
    INTRODUCAO_A_PROGRAMACAO("Introdução à Programação"),
    ESTRUTURA_DE_DADOS_E_ALGORITMOS("Estrutura de Dados e Algoritmos"),
    POO("Programação Orientada a Objetos (POO)"),
    DESENVOLVIMENTO_WEB("Desenvolvimento Web"),
    DESENVOLVIMENTO_DE_APLICATIVOS_MOVEIS("Desenvolvimento de Aplicativos Móveis"),
    DESENVOLVIMENTO_DE_SOFTWARE("Desenvolvimento de Software"),
    PROGRAMACAO_AVANCADA("Programação Avançada"),
    SEGURANCA("Segurança"),
    DEVOPS_E_INFRAESTRUTURA("DevOps e Infraestrutura"),
    PRATICAS_E_METODOLOGIAS_DE_DESENVOLVIMENTO("Práticas e Metodologias de Desenvolvimento"),
    PROJETOS_PRATICOS_E_PORTFOLIO("Projetos Práticos e Portfólio"),
    ESPECIALIZAÇÕES("Especializações");

    private final String descricao;

    Category(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
