package com.torquato.cucumber.example;

import com.google.gson.Gson;
import io.cucumber.java.ParameterType;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;

public class CucumberCustomTypes {

    private final Gson gson = new Gson();

    @SneakyThrows
    @ParameterType("data/person-.*\\.json")
    public PersonService.Person person(String jsonPath) {
        String fullPath = Thread.currentThread().getContextClassLoader().getResource(jsonPath).getPath();
        String json = Files.readString(Path.of(fullPath));
        return gson.fromJson(json, PersonService.Person.class);
    }

}
