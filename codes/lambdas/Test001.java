package codes.lambdas;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class Test001 {
    public static void main(String... args) {
        // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/function/Predicate.html

        // Writing a First Lambda Expression that implements Predicate<String>
        Predicate<String> predicate =
            (String s) -> {
                return s.length() == 3;
            };
        System.out.println("predicate: " + predicate.test("abc"));

        // Simplifying the Syntax
        Predicate<String> predicate2 = s -> s.length() == 3;
        System.out.println("predicate2: " + predicate2.test("hello"));

        // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/function/Consumer.html
        Consumer<String> print = s -> System.out.println(s);

        // https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Runnable.html
        Runnable runnable = () -> System.out.println("I am running.");
    }
}