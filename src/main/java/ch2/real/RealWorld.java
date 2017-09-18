package ch2.real;

import ch2.Apple;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class RealWorld {
    final static Gson gson = new Gson();

    public static void main(String[] args) {
        List<Apple> inventory1 = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        inventory1.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });

        System.out.println("=== Comparator ===");
        inventory1.forEach(n -> System.out.println(gson.toJson(n)));

        List<Apple> inventory2 = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        inventory2.sort((Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor()));
        System.out.println("=== Lambda ===");
        inventory2.forEach(n -> System.out.println(gson.toJson(n)));

        List<Apple> inventory3 = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        inventory3.sort(Comparator.comparing(Apple::getWeight));
        System.out.println("=== Lambda Comparator ===");
        inventory3.forEach(n -> System.out.println(gson.toJson(n)));
    }
}
