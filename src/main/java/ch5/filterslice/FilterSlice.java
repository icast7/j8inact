package ch5.filterslice;

import ch4.util.Dish;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import static ch4.util.Dish.menu;
import static java.util.stream.Collectors.toList;

public class FilterSlice {
    final static Gson gson = new Gson();

    public static void main(String[] args) {
        //Filter
        List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println("### Filter:");
        System.out.println(gson.toJson(vegetarianMenu));

        //Distinct
        List<Integer> numbers = Arrays.asList(8, 1, 2, 1, 4, 3, 2, 7, 8, 3, 10);
        System.out.println("### Distinct:");
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

        //Limit
        List<Dish> dishesGT300Cal = menu.stream().filter(d -> d.getCalories() > 300).limit(2).collect(toList());
        System.out.println("### Limit:");
        System.out.println(gson.toJson(dishesGT300Cal));

        //Skip
        List<Dish> skipFirst2MeatDishes = menu.stream()
                        .filter(d -> d.getType() == Dish.Type.MEAT)
                        .skip(2)
                        .collect(toList());
        System.out.println("### Skip:");
        System.out.println(gson.toJson(skipFirst2MeatDishes));
    }
}
