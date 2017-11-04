package ch5.findmatch;

import ch4.util.Dish;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static ch4.util.Dish.menu;

public class FindMatch {
    final static Gson gson = new Gson();

    public static void main(String[] args) {
        //Match
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!!");
        }

        if (menu.stream().allMatch(d -> d.getCalories() < 1000)) {
            System.out.println("The menu is (somewhat) healthy!!!");
        }

        if (menu.stream().noneMatch(d -> d.getCalories() >= 1000)) {
            System.out.println("The menu is (somewhat) healthy!!!");
        }

        //Find element
        menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d -> System.out.println(d.getName()));

        //Find first element
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst();
        System.out.println(gson.toJson(firstSquareDivisibleByThree));

    }
}
