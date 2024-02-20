package codes.lambdas;

import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntBinaryOperator;

public class Test003 {
    public static void main(String[] args) {
        //
        Consumer<String> printer = System.out::println;

        // Writing Static Method References
        DoubleUnaryOperator sqrt = a -> Math.sqrt(a);
        DoubleUnaryOperator sqrt2 = Math::sqrt;
        // A static method reference may take more than one argument
        IntBinaryOperator max = (a, b) -> Integer.max(a, b);
        IntBinaryOperator max2 = Integer::max;

        // Writing Unbound Method References
        

    }
}
