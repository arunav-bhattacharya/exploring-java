package me.arunav.java.functional;

import me.arunav.java.functional.vo.Gender;
import me.arunav.java.functional.vo.Person;

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

    public static List<Person> createPeople2() {
        return Arrays.asList(
                new Person("Sara", Gender.FEMALE, 20),
                new Person("Sara", Gender.FEMALE, 21),
                new Person("Bob", Gender.MALE, 20),
                new Person("Paula", Gender.FEMALE, 39),
                new Person("Paul", Gender.MALE, 32),
                new Person("Jack", Gender.MALE, 2),
                new Person("Jack", Gender.MALE, 72),
                new Person("Jill", Gender.FEMALE, 12)
        );
    }

    public static void main(String[] args) {
        // toList - Get the list of names, in uppercase of those who are older than 30
        System.out.println(listNamesInUpperCaseAndAgeGT30());

        // toMap - Get a map of names as key and ages and Gender as values
        System.out.println(mapPeopleNamesAsKeyAndRestAsValues());

        // joining - Get comma separated names of people greater than 30
        System.out.println(getCommaSeparatedNamesGT30());

        // partitioningBy - Get List of person partitioned into even and odd ages
        System.out.println(partitionByEvenAndOddAges());

        // groupingBy - Group people based on their name
        System.out.println(groupPersonByNames());

        // groupingBy & mapping - Group ages of people by their name
        System.out.println(groupAgesByNames());

        // groupingBy & counting - Count By Names
        System.out.println(countByNames());

        // groupingBy & collectingThen - Count By Names returning an Int
        System.out.println(countByNamesReturningInt());
    }

    private static Map<String, Integer> countByNamesReturningInt() {
        System.out.println("\ngroupingBy() & counting() - Count By Names & returning Integer");
        return createPeople2()
                .stream()
                .collect(groupingBy(Person::getName, collectingAndThen(counting(), Long::intValue)));
    }

    private static Map<String, Long> countByNames() {
        System.out.println("\ngroupingBy() & counting() - Count By Names");
        return createPeople2()
                .stream()
                .collect(groupingBy(Person::getName, counting()));
    }

    private static Map<String, List<Integer>> groupAgesByNames() {
        System.out.println("\ngroupingBy() & mapping() - Group ages of people by their name");

        // Collector(Function, Collector(Function, Collector)) ---> Recursive structure
        return createPeople2()
                .stream()
                .collect(groupingBy(Person::getName, mapping(Person::getAge, toList())));
    }

    private static Map<String, List<Person>> groupPersonByNames() {
        System.out.println("\ngroupingBy() - Group people based on their name");
        return createPeople2()
                .stream()
                .collect(groupingBy(Person::getName));
    }

    private static Map<Boolean, List<Person>> partitionByEvenAndOddAges() {
        System.out.println("\npartitioningBy() - Get List of person partitioned into even and odd ages");
        return createPeople()
                .stream()
                .collect(partitioningBy(person -> person.getAge() % 2 == 0));
    }

    private static String getCommaSeparatedNamesGT30() {
        System.out.println("\njoining() - Get comma separated names of people greater than 30");
        return createPeople()
                .stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .collect(joining(","));
    }

    private static Map<String, String> mapPeopleNamesAsKeyAndRestAsValues() {
        System.out.println("\ntoMap() - Get a map of names as key and ages and Gender as values");
        return createPeople()
                .stream()
                .collect(toMap(Person::getName, person -> person.getAge() + "-" + person.getGender()));
    }

    private static List<String> listNamesInUpperCaseAndAgeGT30() {
        System.out.println("\ntoList() - Get the list of names, in uppercase of those who are older than 30");
        return createPeople()
                .stream()
                .filter(person -> person.getAge() > 30)
                .map(person -> person.getName().toUpperCase())
                .collect(toUnmodifiableList());
//                .collect(Collectors.toList());
    }
}
