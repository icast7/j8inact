package ch3.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }


    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("", "a", "b", "", "d", "", "e");
        System.out.println("=== All ===");
        stringList.forEach(s -> System.out.println(s));

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(stringList, nonEmptyStringPredicate);

        System.out.println("=== Non Empty ===");
        nonEmpty.forEach(s -> System.out.println(s));
    }
}
