package ch2.real;

import ch2.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ch2.real.RealWorld.gson;

public class RealWorld2 {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(5, "red"));
        apples.add(new Apple(2, "green"));
        apples.add(new Apple(8, "green"));

        Comparator<Apple> color = new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getColor().compareTo(a2.getColor());
            }
        };

        Comparator<Apple> color1 = (Apple a1, Apple a2) -> a1.getColor().compareTo(a2.getColor());

        Comparator<Apple> weight = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        };

        Comparator<Apple> weight1 = (Apple o1, Apple o2) -> Integer.compare(o1.getWeight(), o2.getWeight());
        System.out.println("- - - - - - - - - - - - - - - - -");
        apples.sort(color1);
        apples.forEach(a -> System.out.println(gson.toJson(a)));
        System.out.println("- - - - - - - - - - - - - - - - -");
        apples.sort(weight1);
        apples.forEach(a -> System.out.println(gson.toJson(a)));
    }
}
