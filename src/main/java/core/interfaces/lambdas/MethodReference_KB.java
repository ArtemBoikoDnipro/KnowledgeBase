package core.interfaces.lambdas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;

/**
 * Method References ::
 *
 * @author Artem Boiko
 */
public class MethodReference_KB {
    private static final Logger logger = LogManager.getLogger(MethodReference_KB.class);

    public static void main(String[] args) {
        /* instead of */
        Consumer<String> stringSupplier = s -> System.out.println(s);

        /* method reference used */
        Consumer<String> refStringSupplier = System.out::println;



        /* instead of */
        Function<Integer, Integer> abs = i -> Math.abs(i);

        /* static method reference
         * (Class:staticMethodName)
         */
        Function<Integer, Integer> refAbs = Math::abs;



        /* instance method reference
         * (obj:methodName)
         */
        ThreadLocalRandom randomObject = ThreadLocalRandom.current();
        IntSupplier intSupplier = randomObject::nextInt;
        logger.info("intSupplier = {}", intSupplier);

        String hello = "hello";
        Function<Integer, String> substringFunction = hello::substring;
        String subHello = substringFunction.apply(1);  /* cut one char */
        logger.info("subHello = {}", subHello); // ello



        /* class method reference
         * (Class:methodName)
         */
        Function<String, String> stringFunction = String::toUpperCase;

        hello = "hello";
        /*
         * если же ссылка на класс,
         * то всегда на один параметр больше нужно передавать лямбде,
         * так как нужно передать объект класса (потому что метод нестатический)
         */
        BiFunction<String, Integer, String> substringBiFunction = String::substring;
        subHello = substringBiFunction.apply(hello, 1);  /* cut one char */
        logger.info("subHello = {}", subHello);   // ello


    }
}
