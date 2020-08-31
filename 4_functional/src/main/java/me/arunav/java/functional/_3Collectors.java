package me.arunav.java.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toUnmodifiableList;

public class _3Collectors {

    public static List<Person> createPeople() {
        return Arrays.asList(
                new Person("Sara", Gender.FEMALE, 20),
                new Person("Sara1", Gender.FEMALE, 22),
                new Person("Bob", Gender.MALE, 20),
                new Person("Paula", Gender.FEMALE, 32),
                new Person("Paul", Gender.MALE, 32),
                new Person("Jack1", Gender.MALE, 2),
                new Person("Jack", Gender.MALE, 72),
                new Person("Jill", Gender.FEMALE, 12)
        );
    }

    public static void main(String[] args) {
        // Get the list of names, in uppercase of those who are older than 30
        System.out.println(getListOfNamesInUpperCaseAndAgeGT30());

        // Get a map of names as key and ages and Gender as values
        System.out.println(getMapOfPeopleNamesAsKeyAndRestAsValues());

    }

    private static Map<String, String> getMapOfPeopleNamesAsKeyAndRestAsValues() {
        return createPeople()
                .stream()
                .collect(toMap(person -> person.getName(), person -> person.getAge() + "-" + person.getGender()));
    }

    // Get the list of names, in uppercase of those who are older than 30
    private static List<String> getListOfNamesInUpperCaseAndAgeGT30() {
        return createPeople()
                .stream()
                .filter(person -> person.getAge() > 30)
                .map(person -> person.getName().toUpperCase())
                .collect(toUnmodifiableList());
//                .collect(Collectors.toList());
    }
}
