package com.example.people.dto.req;

import lombok.Getter;

@Getter
public class PersonRequestDTO {

    private String name;
    private String cpf;
    private Integer age;

    public PersonRequestDTO(Integer age, String cpf, String name) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
    }
}
