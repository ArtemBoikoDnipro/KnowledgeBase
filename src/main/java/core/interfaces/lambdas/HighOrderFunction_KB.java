package core.interfaces.lambdas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * High order function.
 *
 * @author Artem Boiko
 */
public class HighOrderFunction_KB {
    private static final Logger logger = LogManager.getLogger(HighOrderFunction_KB.class);

    public static void main(String[] args) {
        Function<Function<String, Integer>, Predicate<String>> highOrderFunction;

        /* long way */
        highOrderFunction = stringToIntFunction -> {
            return str -> stringToIntFunction.apply(str) > 0;
        };

        /* short way */
        highOrderFunction = stringToIntFunction -> str -> stringToIntFunction.apply(str) > 0;


        Predicate<String> positiveNumber;
        /* NOT optimized (redundant private static method creation) */
        positiveNumber = highOrderFunction.apply(s -> Integer.parseInt(s));
        /* optimized (INVOKEDYNAMIC) */
        positiveNumber = highOrderFunction.apply(Integer::parseInt);

        String negativeNumberAsString = "-1";
        String zeroNumberAsString = "0";
        String positiveNumberAsString = "1";

        boolean negativeTest = positiveNumber.test(negativeNumberAsString);
        boolean zeroTest = positiveNumber.test(zeroNumberAsString);
        boolean positiveTest = positiveNumber.test(positiveNumberAsString);

        logger.info("Testing negativeNumberAsString: {} > 0 | {}", negativeNumberAsString, negativeTest);
        logger.info("Testing zeroNumberAsString:      {} > 0 | {}", zeroNumberAsString, zeroTest);
        logger.info("Testing positiveNumberAsString:  {} > 0 | {}", positiveNumberAsString, positiveTest);
    }
}
