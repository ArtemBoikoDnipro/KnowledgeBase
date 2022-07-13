package core.lambdas;

import java.util.function.*;

/**
 * Functional interfaces.
 *
 * @author Artem Boiko
 */
public class FunctionalInterface_KB {
    public static void main(String[] args) {

        Integer integer = 111;
        Consumer<Integer> integerConsumer = i -> System.out.println("integer in consumer = " + i);
        integerConsumer.accept(integer);


        Consumer<String> stringConsumer = s -> System.out.println("stringConsumer = " + s);
        Supplier<String> stringSupplier = () -> "string in supplier";
        String stringFromSupplier = stringSupplier.get();
        stringConsumer.accept(stringFromSupplier);


        Function<String, Integer> stringIntegerFunction = Integer::parseInt;
        Integer functionResult = stringIntegerFunction.apply("555");
        integerConsumer.accept(functionResult);


        stringConsumer.accept(predicateTesting("abc", "a"));
        stringConsumer.accept(predicateTesting("def", "b"));


        BiConsumer<String, Integer> biConsumer = (s, i) -> System.out.println("biConsumer: " + s + " = " + i);
        biConsumer.accept("aaa", 3);


        IntSupplier intSupplier = () -> 1;
        integerConsumer.accept(intSupplier.getAsInt());


        BiFunction<String, Boolean, String> biFunction = (s, must) ->
                "string '" + s +
                (must ? "' must contains 'a'" : "' should not contains 'a'")
                + ". Is it so: " +
                (must == s.contains("a"));

        String abc = biFunction.apply("abc", true);
        stringConsumer.accept(abc);

        String abcNOT = biFunction.apply("abc", false);
        stringConsumer.accept(abcNOT);

        String def = biFunction.apply("def", true);
        stringConsumer.accept(def);
    }

    private static String predicateTesting(String input, String containsChar) {
        Predicate<String> stringPredicate = s -> s.contains(containsChar);
        boolean isContain = stringPredicate.test(input);
        return "string '" + input + "' has '" + containsChar + "' = " + isContain;
    }
}
