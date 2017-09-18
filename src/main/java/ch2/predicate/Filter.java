package ch2.predicate;

import ch2.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;

public class Filter {
    final static Gson gson = new Gson();

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println("=== Apples ===");
        redApples.forEach(a -> System.out.println(gson.toJson(a)));

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
        System.out.println("=== Numbers ===");
        evenNumbers.forEach(n -> System.out.println(gson.toJson(n)));
    }
}
