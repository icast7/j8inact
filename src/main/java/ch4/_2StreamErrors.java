package ch4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _2StreamErrors {
    public static void main(String[] args) {
        try {
            List<String> title = Arrays.asList("Java8", "In", "Action");
            Stream<String> s = title.stream();
            System.out.println("1st time");
            s.forEach(System.out::println);
            Thread.sleep(1000);
            System.out.println("\n2nd time");
            s.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
