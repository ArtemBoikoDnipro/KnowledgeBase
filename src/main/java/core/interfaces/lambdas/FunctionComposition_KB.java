package core.interfaces.lambdas;

import core.entity.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

/**
 * Function composition.
 * f(x), g(x) -> f(g(x))
 *
 * @author Artem Boiko
 */
public class FunctionComposition_KB {
    private static final Logger logger = LogManager.getLogger(FunctionComposition_KB.class);

    public static void main(String[] args) {
        example();
        comparatorExample();
        predicatesExample();
    }

    private static void example() {
        IntUnaryOperator square = x -> x * x;
        IntUnaryOperator increment = x -> x + 1;
        IntUnaryOperator incrementAndSquare = square.compose(increment);
        IntUnaryOperator squareAndIncrement = square.andThen(increment);

        int operand = 2;
        int result = incrementAndSquare.applyAsInt(operand);
        logger.info("Increment '{}' and square it: {}", operand, result);

        result = squareAndIncrement.applyAsInt(operand);
        logger.info("Square '{}' and increment it: {}", operand, result);
    }

    private static void comparatorExample() {
        Account accountOne = new Account(1, "one-first", "one-last");
        Account accountTwo = new Account(2, "two-first", "two-last");
        Account accountThree = new Account(3, "three-first", "three-last");

        List<Account> accounts = Arrays.asList(accountOne, accountTwo, accountThree);
        accounts.forEach(logger::info);
        accounts.sort(Comparator.comparing(Account::getFirstName)
                                .thenComparing(Account::getLastName));
        accounts.forEach(logger::info);
    }

    private static void predicatesExample() {
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> longWord = s -> s.length() > 5;
        Predicate<String> longWordStartsWithA = startsWithA.and(longWord);

        String shortWord = "Aaa";
        String longStringA = "Aaaaaaaaaaaaaa";
        String longStringB = "Baaaaaaaaaaaaa";

        boolean isShortWord = longWordStartsWithA.test(shortWord);
        boolean isLongWordA = longWordStartsWithA.test(longStringA);
        boolean isLongWordB = longWordStartsWithA.test(longStringB);
        logger.info("Testing '{}': starts with 'A' and long as well ? | {}", shortWord, isShortWord);
        logger.info("Testing '{}': starts with 'A' and long as well ? | {}", longStringA, isLongWordA);
        logger.info("Testing '{}': starts with 'A' and long as well ? | {}", longStringB, isLongWordB);
    }
}
