package ch3;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferences {
    final static Gson gson = new Gson();

    public static void main(String[] args) {
        Supplier<Apple> c1 = Apple::new;
        System.out.println("=== Apple() ===");
        Apple a1 = c1.get();
        System.out.println(gson.toJson(a1));

        Function<Integer, Apple> c2 = Apple::new;
        Apple a2 = c2.apply(110);
        System.out.println("=== Apple(weight) ===");
        System.out.println(gson.toJson(a2));

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);
        System.out.println("=== Apples from weight list ===");
        System.out.println(gson.toJson(apples));

        BiFunction<Integer, String, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(110, "green");
        System.out.println("=== Apples from 2 argument constructor ===");
        System.out.println(gson.toJson(a3));
    }

    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e));
        }
        return result;
    }
}