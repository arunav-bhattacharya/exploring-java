package me.arunav.java.functional;

import me.arunav.java.functional.vo.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class _4ComplexCollector {

    public static void main(String[] args) {

        // Find the product which has the maximum singular usage, i.e., the product is used by a person, and no other products are used by the same person,
        // and it has the maximum usage by a single person when combined all singular usages
        // In the below example -
        // Coffee is singularly used by Riya, James and Maddy, and they have used it only once.
        // Book is singularly used by Jack twice.
        // So the singular usage of coffee is 3 and that of Book is 2. So answer should be Coffee.
        String[][] data = {
                {"John", "Book"},
                {"John", "Coffee"},
                {"Jack", "Book"},
                {"Jack", "Book"},
                {"Riya", "Coffee"},
                {"James", "Coffee"},
                {"Maddy", "Coffee"}
        };

        String s = Arrays.asList(data)
                .stream()
                .map(i -> new Pair<>(i[0], i[1]))
                .collect(groupingBy(Pair::getFirst, groupingBy(Pair::getSecond, counting())))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() == 1)
                .map(entry -> new Pair<>(entry.getValue().keySet().stream().findFirst().get(), entry.getValue().entrySet().stream().findFirst().get().getValue()))
                .collect(groupingBy(Pair::getFirst, collectingAndThen(counting(), Long::intValue)))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .get().getKey();

        System.out.println(s);

    }
}
