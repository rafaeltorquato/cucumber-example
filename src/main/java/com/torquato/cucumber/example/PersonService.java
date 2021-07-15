package com.torquato.cucumber.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public Person save(Person person) {
        return null; //TODO Do it!
    }


    @Getter
    @Setter
    public static class Person {
        private String name;
        private LocalDate birthDay;
    }

    public interface PersonRepository {
        void save(Person person);
    }
}
