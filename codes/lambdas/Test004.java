package codes.lambdas;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Logger;

public class Test004 {
    public static void main(String[] args) {
        // Chaining Predicates with Default Methods
        // Suppose you need to process a list of strings, to keep only the strings that are non-null, non-empty, and shorter than 5 characters.
        String str = "hi";

        Predicate<String> p1 = s -> (s != null) && !s.isEmpty() && s.length() < 5;
        System.out.println(p1.test(str));

        Predicate<String> nonNull = s -> s != null;
        Predicate<String> nonEmpty = s -> !s.isEmpty();
        Predicate<String> shorterThan5 = s -> s.length() < 5;
        Predicate<String> p2 = nonNull.and(nonEmpty).and(shorterThan5);
        System.out.println(p2.test(str));

        Predicate<String> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNullOrEmpty = isNull.or(isEmpty);
        Predicate<String> isNotNullNorEmpty = isNullOrEmpty.negate();
        Predicate<String> p3 = isNotNullNorEmpty.and(shorterThan5);
        System.out.println(p3.test(str));

        // Creating Predicates with Factory Methods
        Predicate<String> isEqualToDuke = Predicate.isEqual("Duke");
        System.out.println(isEqualToDuke.test(str));

        Predicate<String> isNotEmpty = Predicate.not(isEmpty);
        System.out.println(isNotEmpty.test(str));

        // Chaining Consumers with Default Methods
        Logger logger = Logger.getLogger("MyAppLog");
        Consumer<String> log = message -> logger.info(message);
        Consumer<String> print = System.out::println;
        Consumer<String> logAndPrint = log.andThen(print);
        logAndPrint.accept(str);

        // Chaining and Composing Functions with Default Methods
        // What you need to realize is that to get the same resulting function, you need to call andThen() on f1 or compose() on f2.

        // Creating an Identity Function ?
    }
}
