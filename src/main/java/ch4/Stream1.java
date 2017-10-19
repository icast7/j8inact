package ch4;

import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Stream1 {
    final static Gson gson = new Gson();

    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames = Dish.menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(toList());
        System.out.println("*** 300 Caloric Dished  ");
        System.out.println(threeHighCaloricDishNames);

        List<String> parallelThreeHighCaloricDishNames = Dish.menu.parallelStream()
                        .filter(d -> d.getCalories() > 300)
                        .map(Dish::getName)
                        .limit(3)
                        .collect(toList());
        System.out.println("*** Parallel 300 Caloric Dished  ");
        System.out.println(parallelThreeHighCaloricDishNames);

        Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream().collect(groupingBy(Dish::getType));
        System.out.println("***  Dishes grouped by type");
        System.out.println(gson.toJson(dishesByType));
    }
}
