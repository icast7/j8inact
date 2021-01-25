package ch5.reduce;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static ch4.util.Dish.menu;

public class Reduce {
    final static Gson gson = new Gson();

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }
        System.out.println("\nSum:" + sum);

        int streamSum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("\nStream Sum:" + streamSum);

        int streamStaticSum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("\nStream Static Sum:" + streamStaticSum);

        Optional<Integer> streamStaticNoInitSum = numbers.stream().reduce((a, b) -> (a + b));
        System.out.println("\nStream Static No Init Sum:" + gson.toJson(streamStaticNoInitSum));

        int streamProduct = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("\nStream Product:" + streamProduct);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("\nMax:" + gson.toJson(max));

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println("\nMin:" + gson.toJson(min));

        //Count
        int countReduced = menu.stream().map(d-> 1).reduce(0, (a,b) -> a+b);
        System.out.println("\nReduced count menu items:" + countReduced);

        long count= menu.stream().count();
        System.out.println("\nCount menu items:" + count);

        int sumReduce = numbers.parallelStream().reduce(0, Integer::sum);
        System.out.println("\nSum reduce:" + sumReduce);

    }
}
