package com.example.testesuitariosEstudos.testesunitariosestudos.service;

import com.example.testesuitariosEstudos.testesunitariosestudos.dominio.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    private Person adult;
    private Person notAdult;
    private PersonService personService;

    @BeforeEach
    public void setUp() {
        adult = new Person(18);
        notAdult = new Person(15);
        personService = new PersonService();
    }

    @Test
    @DisplayName("A person should be not adult when age is lower than 18")
    void isAdult_returnFalse_whenAgeIsLowerThan18() {
        assertFalse(personService.isAdult(notAdult));
    }

    @Test
    @DisplayName("A person should be adult when age is greater or equal than 18")
    void isAdult_returnTrue_whenAgeIsGreaterOrEqualThan18() {
        assertTrue(personService.isAdult(adult));
    }

    @Test
    @DisplayName("Should throw null pointer exception with message when person is null")
    void isAdult_shouldThrowException_WhenPersonIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> personService.isAdult(null), "Person can't be null");
    }

    @Test
    @DisplayName("Should return a list with only adults.")
    void filterRemovingNotAdult_returnListWithAdultOnly_WhenListOfPersonWithAdultIsPassed() {
        Person person1 = new Person(17);
        Person person2 = new Person(18);
        Person person3 = new Person(21);
        List<Person> personList = List.of(person1, person2, person3);
        Assertions.assertEquals(2, personService.filterRemovingNotAdult(personList).size());
    }
}