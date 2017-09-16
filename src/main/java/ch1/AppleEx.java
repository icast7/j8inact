package ch1;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class AppleEx {

    public static final String GREEN = "green";
    public static final String RED = "red";
    public static final String YELLOW = "yellow";
    final static Gson gson = new Gson();

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(GREEN, 120));
        inventory.add(new Apple(RED, 160));
        inventory.add(new Apple(YELLOW, 120));
        inventory.add(new Apple(GREEN, 170));
        inventory.add(new Apple(GREEN, 250));

        System.out.println("=== HEAVY APPLES ===");
        List heavyApples = inventory.stream().filter(a -> a.getWeight() > 150).collect(toList());
        heavyApples.forEach(a -> System.out.println(gson.toJson(a)));


        System.out.println("=== GREEN APPLES ===");
        List greenApples = inventory.parallelStream().filter(a -> GREEN.equals(a.getColor())).collect(toList());
        greenApples.forEach(a -> System.out.println(gson.toJson(a)));
    }

    static class Apple {
        private String color;
        private int weight;

        public Apple(String color, int weight) {
            this.color = color;
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public int getWeight() {
            return weight;
        }
    }
}
