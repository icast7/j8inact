package ch3.composition;

import ch3.fruit.Apple;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class ComparatorExample {
    final static Gson gson = new Gson();

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(9, "red", "CN"),
                new Apple(10, "red", "CN"),
                new Apple(10, "green", "MX"),
                new Apple(10, "yellow", "US")
        );

        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getCountry));
        inventory.forEach(a ->System.out.println(gson.toJson(a)));
    }
}
