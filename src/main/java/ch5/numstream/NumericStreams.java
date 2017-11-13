package ch5.numstream;

import ch4.util.Dish;

import static ch4.util.Dish.menu;

public class NumericStreams {
    public static void main(String[] args){
        int caloriesMap = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println("All calories with Map: " + caloriesMap);

        int caloriesMapInt = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("All calories with MapInt: " + caloriesMapInt);

    }
}