package ch4;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Stream1 {
    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames = Dish.menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(toList());
        System.out.println(threeHighCaloricDishNames);
    }
}
