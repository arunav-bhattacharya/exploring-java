package me.arunav.java.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class _3Collectors {

    public static List<Person> createPeople() {
        return Arrays.asList(
                new Person("Sara", Gender.FEMALE, 20),
                new Person("Sarat", Gender.FEMALE, 21),
                new Person("Bob", Gender.MALE, 20),
                new Person("Paula", Gender.FEMALE, 39),
                new Person("Paul", Gender.MALE, 32),
                new Person("Jim", Gender.MALE, 2),
                new Person("Jack", Gender.MALE, 72),
                new Person("Jill", Gender.FEMALE, 12)
        );
    }

    public static void main(String[] args) {
        // toList - Get the list of names, in uppercase of those who are older than 30
        System.out.println(getListOfNamesInUpperCaseAndAgeGT30());

        // toMap - Get a map of names as key and ages and Gender as values
        System.out.println(getMapOfPeopleNamesAsKeyAndRestAsValues());

        // joining - Get comma separated names of people greater than 30
        System.out.println(getCommaSeparatedNamesGT30());

        // partitioningBy - Get List of person partitioned into even and odd ages
        System.out.println(getPartitionedPeopleByEvenAndOddAges());
    }

    private static Map<Boolean, List<Person>> getPartitionedPeopleByEvenAndOddAges() {
        return createPeople()
                .stream()
                .collect(partitioningBy(person -> person.getAge() % 2 == 0));
    }

    private static String getCommaSeparatedNamesGT30() {
        return createPeople()
                .stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .collect(joining(","));
    }

    private static Map<String, String> getMapOfPeopleNamesAsKeyAndRestAsValues() {
        return createPeople()
                .stream()
                .collect(toMap(Person::getName, person -> person.getAge() + "-" + person.getGender()));
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
