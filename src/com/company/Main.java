package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        public static void main(String[] args) {
            PeopleStats peopleStats = new PeopleStats(Paths.get("śćieżka", "do", "pliku"));

            System.out.println(String.format("Liczba osób: %d", peopleStats.count()));
            System.out.println(String.format("Liczba osób z unikalnymi nazwiskami: %d", peopleStats.countUniqueLastNames()));
        }
    }
}

class PeopleStats {
    private final List<Person> people;

    public PeopleStats(Path inputFilePath) {
        try {
            people = Files.lines(inputFilePath)
                    .map(line -> line.split("\t"))
                    .map(chunks -> new Person(chunks[0], chunks[1]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
    public long count() {
        return people.size();
    }

    public long countUniqueLastNames() {
        return people.stream()
                .map(Person::getLastName)
                .distinct()
                .count();
    }
}
class Person {
    private final String firstName;
    private final String latsName;

    public String getLatsName() {
        return latsName;
    }

    public Person(String firstName, String latsName) {
        this.firstName = firstName;
        this.latsName = latsName;
    }

    public String getFirstName() {
        return firstName;
    }
}