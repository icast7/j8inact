package ch5.infinite;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InifiniteStream {
    public static void main(String[] args) {
        System.out.println("Iterate: Infinite even numbers stream:");
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        System.out.println("Fibonacci Iterate (Tuples):");
        Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] })
                        .limit(20)
                        .forEach(f -> System.out.println("(" + f[0] + "," + f[1] + ")"));

        System.out.println("Fibonacci Iterate (Series):");
        Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] })
                        .limit(10)
                        .map(t -> t[0])
                        .forEach(System.out::println);

        System.out.println("Random numbers Generate");
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        System.out.println("Ones! Generate");
        IntStream.generate(() -> 1).limit(5).forEach(System.out::println);

        System.out.println("Twos! (No boxing) Generate");
        IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt() {
                return 2;
            }
        }).limit(5).forEach(System.out::println);

        System.out.println("Fibonacci with anonymous class");
        final IntSupplier fibSupplier = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fibSupplier).limit(10).forEach(System.out::println);
    }
}
