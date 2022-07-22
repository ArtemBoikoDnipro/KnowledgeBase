package core.interfaces.lambdas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.*;

/**
 * Functional interfaces.
 *
 * @author Artem Boiko
 */
public class FunctionalInterface_KB {
    private static final Logger logger = LogManager.getLogger(FunctionalInterface_KB.class);

    public static void main(String[] args) {
        /*
         * Consumer - functional interface
         * System.out.println(...) - function
         * logger.info(...) - function
         *
         * лямбда - анонимная функция,
         * которая имплементирует абстрактный метод функционального интерфейса
         */

        /*
         * SAM - single abstract method
         *
         * FI              SAM      Params  Return type
         * Consumer<T>	   accept	T		void
         * Supplier<T>	   get		-		T
         * Function<T,R>   apply	T		R
         * Predicate<T>	   test	    T		boolean
         *
         * BiConsumer<T, U>
         * BiFunction<T, U, R>
         * IntSupplier
         * BiPredicate<T, U>
         */

        Consumer<Integer> integerConsumer = i -> logger.info("integer in consumer = " + i);
        Integer integer = 111;
        integerConsumer.accept(integer);


        Consumer<String> stringConsumer = s -> logger.info("stringConsumer = " + s);
        Supplier<String> stringSupplier = () -> "string in supplier";
        String stringFromSupplier = stringSupplier.get();
        stringConsumer.accept(stringFromSupplier);


        Function<String, Integer> stringIntegerFunction = Integer::parseInt;
        Integer parsedInteger = stringIntegerFunction.apply("555");
        integerConsumer.accept(parsedInteger);


        stringConsumer.accept(predicateTesting("abc", "a"));
        stringConsumer.accept(predicateTesting("def", "b"));


        BiConsumer<String, Integer> biConsumer = (s, i) -> logger.info("biConsumer: 1={}, 2={}", s, i);
        biConsumer.accept("aaa", 3);


        IntSupplier intSupplier = () -> 1;
        integerConsumer.accept(intSupplier.getAsInt());


        biFunction(stringConsumer);
    }

    private static String predicateTesting(String input, String containsChar) {
        Predicate<String> stringPredicate = s -> s.contains(containsChar);
        boolean isContain = stringPredicate.test(input);
        return "string '" + input + "' has '" + containsChar + "' = " + isContain;
    }

    private static void biFunction(Consumer<String> stringConsumer) {
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
}
