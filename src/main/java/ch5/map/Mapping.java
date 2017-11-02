package ch5.map;

import ch4.util.Dish;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import static ch4.util.Dish.menu;
import static java.util.stream.Collectors.toList;

public class Mapping {
    final static Gson gson = new Gson();

    public static void main(String[] args) {
        System.out.println("Dish mapped to dish name string:");
        List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());
        System.out.println(gson.toJson(dishNames));

        System.out.println("\nString to string length map:");
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
        System.out.println(gson.toJson(wordLengths));

        System.out.println("\nDish name length map:");
        List<Integer> dishNameLengths = menu.stream().map(Dish::getName).map(String::length).collect(toList());
        System.out.println(gson.toJson(dishNameLengths));
    }
}
