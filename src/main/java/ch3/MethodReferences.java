package ch3;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReferences {
    public static void main(String[] args) {
        Function<String, Integer> stringIntegerFunction = Integer::parseInt;
        BiPredicate<List<String>, String> contains = List::contains;
    }
}