package ch3.composition;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        Function<Integer, Integer> i = f.compose(g);

        int resultFandThenG = h.apply(2);
        System.out.println("== f andThen g ==");
        System.out.println(resultFandThenG);

        int resultFcomposeG = i.apply(2);
        System.out.println("== f compose g ==");
        System.out.println(resultFcomposeG);


    }
}
