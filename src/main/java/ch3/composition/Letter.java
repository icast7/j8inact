package ch3.composition;

import java.util.function.Function;

public class Letter {
    public static String addHeader(String text) {
        return "From Mario and Luigi:\n\n" + text;
    }

    public static String addFooter(String text) {
        return text + "\n\nKind regards,";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }

    static Function<String, String> addHeader = Letter::addHeader;
    static Function<String, String> transformationPipeline =
            addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);

    public static void main(String[] args){
        String result = transformationPipeline.apply("This is the labda example.");
        System.out.println(result);
    }
}
