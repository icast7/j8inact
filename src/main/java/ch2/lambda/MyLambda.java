package ch2.lambda;

interface StringFunction {
    String run(String string);
}

public class MyLambda {
    public static void main(String[] args) {
        StringFunction exclaim = s -> s + "!";
        StringFunction ask = s -> s + "?";
        printFormatted("blas", exclaim);
        printFormatted( "blas", ask);
    }

    private static void printFormatted(String s, StringFunction format) {
        String result = format.run(s);
        System.out.println(result);
    }
}
