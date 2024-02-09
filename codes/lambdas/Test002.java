package codes.lambdas;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

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
    }
}
