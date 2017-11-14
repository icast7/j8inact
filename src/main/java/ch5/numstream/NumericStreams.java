package ch5.numstream;

import ch4.util.Dish;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static ch4.util.Dish.menu;

public class NumericStreams {
    public static void main(String[] args) {
        int caloriesMap = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println("All calories with Map: " + caloriesMap);

        int caloriesMapInt = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("All calories with MapInt: " + caloriesMapInt);

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
        System.out.println("All ints as Integers:r");
        stream.forEach(System.out::println);

        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
        int max = maxCalories.orElse(1);
        System.out.println("Max calories: " + max);

        IntStream evenNumbersInc = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println("Even numbers count (inclusive): " + evenNumbersInc.count());

        IntStream evenNumbersExc = IntStream.range(1, 100).filter(n -> n % 2 == 0);
        System.out.println("Even numbers count (exclusive): " + evenNumbersExc.count());


        System.out.println("Pythagorean  Triples: ");
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed().flatMap(a ->
        IntStream.rangeClosed(a, 100).filter(b-> Math.sqrt(a*a + b*b) % 1 ==0).mapToObj(b-> new int[] {a,b, (int)Math.sqrt(a*a + b*b)}));
        pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0]+", " + t[1]+", " + t[2]));


    }
}