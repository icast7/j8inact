package ch3.composition;

import ch3.fruit.Apple;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static ch3.predicate.PredicateExample.filter;

public class PredicateExample {
    final static Gson gson = new Gson();

    static Predicate<Apple> redApple = a -> "red".equals(a.getColor());

    static Predicate<Apple> redAndHeavyOrGreenApple =
            redApple.and(a -> a.getWeight() > 150).or(a -> "green".equals(a.getColor()));

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(151, "red"),
                new Apple(149, "red"),
                new Apple(100, "green"),
                new Apple(200, "yellow")
        );

        List<Apple> apples = filter(inventory, redAndHeavyOrGreenApple);
        apples.forEach(a -> System.out.println(gson.toJson(a)));
    }
}
