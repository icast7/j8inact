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

        System.out.println("\nFlat map:");
        List<String> uniqueCharacters = words.stream()
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(toList());
        System.out.println(gson.toJson(uniqueCharacters));

        System.out.println("\nSquares:");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(n -> n * n).collect(toList());
        System.out.println(gson.toJson(squares));

        System.out.println("\nPairs of numbers:");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(5, 6);
        List<int[]> pairs = numbers1.stream()
                        .flatMap(i -> numbers2.stream().map(j -> new int[] { i, j }))
                        .collect(toList());
        System.out.println(gson.toJson(pairs));

        System.out.println("\nPairs of numbers whose sum is divisible by 3:");
        List<Integer> numbers3 = Arrays.asList(1, 2, 3);
        List<Integer> numbers4 = Arrays.asList(5, 6);
        List<int[]> pairsDivisibleBy3 = numbers3.stream()
                        .flatMap(i -> numbers4.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[] { i, j }))
                        .collect(toList());
        System.out.println(gson.toJson(pairsDivisibleBy3));
    }
}
