package me.arunav.java.functional;

import java.util.Arrays;
import java.util.List;

public class _2Streams {
    static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {

        //given the values, double the even numbers and total.
        System.out.println(getSumOfDoubleOfEvenNumbers());

        //given an ordered list find the double of the first even number greater than 3.
        System.out.println(getDoubleOfFirstEvenNumberGT3());
    }

    private static int getDoubleOfFirstEvenNumberGT3() {
        return numbers
                .stream()
                .filter(num -> num > 3)
                .filter(num -> num % 2 == 0)
                .map(num -> num * 2)
                .findFirst()
                .orElse(0);
    }

    private static int getSumOfDoubleOfEvenNumbers() {
        return numbers
                .stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number * 2)
                .sum();
        //.reduce(0, Integer::sum);
        //.reduce(0, (number, total) -> number + total);

    }
}
