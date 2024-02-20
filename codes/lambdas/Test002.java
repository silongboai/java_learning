package codes.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class Test002 {
    public static void main(String[] args) {
        // This lambda expression simply returns the Hello Duke! string of characters.
        Supplier<String> supplier = () -> "Hello World!";
        System.out.println(supplier.get());

        // You can also write a supplier that returns a new object every time it is invoked
        Random random = new Random(314L);
        // this lambda is capturing a variable from the enclosing scope: random, making this variable effectively final
        Supplier<Integer> supplier2 = () -> random.nextInt(10);
        for (int i = 0; i < 5; i++) {
            System.out.println(supplier2.get());
        }
        // This boxing / unboxing does not come for free.
        // IntSupplier, BooleanSupplier, LongSupplier and DoubleSupplier.
        IntSupplier supplier3 = () -> random.nextInt(10);
        for (int i = 0; i < 5; i++) {
            System.out.println(supplier3.getAsInt());
        }

        //
        Consumer<Integer> printer = i -> System.out.println(i);
        for (int i = 0; i < 5; i++) {
            printer.accept(supplier3.getAsInt());
        }
        //  IntConsumer, LongConsumer, and DoubleConsumer
        IntConsumer consumer = i -> System.out.println(i);
        for (int i = 0; i < 5; i++) {
            consumer.accept(supplier3.getAsInt());
        }

        // Consuming Two Elements with a BiConsumer
        // ObjIntConsumer<T>, ObjLongConsumer<T> and ObjDoubleConsumer<T>
        BiConsumer<Random, Integer> randomNumberConsumer =
            (rand, num) -> {
                for (int i = 0; i < num; i++) {
                    System.out.println(rand.nextInt(10));
                }
            };
        randomNumberConsumer.accept(random, 5);

        // Passing a Consumer to an Iterable
        Consumer<String> c = s -> System.out.println(s);
        List<String> strings = List.of("Hello", "world");
        strings.forEach(c);

        //
        Predicate<String> length3 = s -> s.length() == 3;
        System.out.println(length3.test("hello"));

        // IntPredicate, LongPredicate, and DoublePredicate
        IntPredicate isGreaterThan10 = i -> i > 10;
        System.out.println(isGreaterThan10.test(11));

        // Testing Two Elements with a BiPredicate
        BiPredicate<String, Integer> isOfLength = (word, length) -> word.length() == length;
        System.out.println(isOfLength.test("hello", 3));

        // Passing a Predicate to a Collection
        List<String> immutableStrings = List.of("one", "two", "three", "four", "five");
        List<String> strings1 = new ArrayList<>(immutableStrings);
        Predicate<String> isOddLength = s -> s.length() % 2 == 0;
        strings1.removeIf(isOddLength);
        System.out.println(strings1);

        //
        Function<String, Integer> toLength = s -> s.length();
        String word = "test";
        int length = toLength.apply(word);
        System.out.println(length);

        // 16 specialized types of functions
        // Passing a Unary Operator to a List
        List<String> strings2 = Arrays.asList("one", "two", "three");
        UnaryOperator<String> toUpperCase = w -> w.toUpperCase();
        strings2.replaceAll(toUpperCase);
        System.out.println(strings2);
    }
}
