package ch5.create;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class From {

    public static void main(String[] args) {
        Stream<String> streamStr = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        streamStr.map(String::toUpperCase).forEach(System.out::println);
        Stream<String> emptyString = Stream.empty();
        emptyString.map(String::toUpperCase).forEach(System.out::println);

        int[] numbers = { 2, 3, 5, 7, 11, 13 };
        int sum = Arrays.stream(numbers).sum();
        System.out.println("Sum: " + sum);

        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource("mydata.txt").toURI()),
                        Charset.defaultCharset())) {

            uniqueWords = lines.flatMap(l -> Arrays.stream(l.split(" "))).distinct().count();
            System.out.println("Number of unique words: " + uniqueWords);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
