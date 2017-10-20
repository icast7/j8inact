package ch4;

import ch4.util.Dish;
import com.google.gson.Gson;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class _3IntermediateOperations {
    final static Gson gson = new Gson();

    public static void main(String[] args) {
        System.out.println("*** Intermediate Operations ***");
        List<String> names = Dish.menu.stream().filter(d -> {
            System.out.println("filtering: " + d.getName());
            return d.getCalories() > 300;
        }).map(d -> {
            System.out.println("mapping: " + d.getName());
            return d.getName();
        }).limit(3).collect(toList()); System.out.println(names);

        System.out.println("\n*** Terminal Operations ***");
        Dish.menu.stream().forEach(d -> System.out.println(gson.toJson(d)));
    }
}
