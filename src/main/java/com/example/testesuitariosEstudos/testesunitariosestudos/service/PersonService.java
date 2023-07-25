package com.example.testesuitariosEstudos.testesunitariosestudos.service;

import com.example.testesuitariosEstudos.testesunitariosestudos.dominio.Person;

import java.util.List;

public class PersonService {
    public boolean isAdult(Person person) {
//        Objects.requireNonNull(person, "Person can't be null");
        if (person == null) {
            throw new IllegalArgumentException();
        }
        return person.getAge() >= 18;
    }

    public List<Person> filterRemovingNotAdult(List<Person> personList) {
        return personList.stream()
                         .filter(this::isAdult)
                         .toList();
    }
}
