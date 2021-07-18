package com.torquato.cucumber.example;

import lombok.*;

import java.time.*;

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
        private LocalDate birthDate;

    }

    public interface PersonRepository {

        void save(Person person);

    }

}
