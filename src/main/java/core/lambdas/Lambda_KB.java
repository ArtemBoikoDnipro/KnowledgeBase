package core.lambdas;

import collection.ConversionListToMap_KB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.function.Consumer;

/**
 * Lambdas, functional interfaces.
 *
 * @author Artem Boiko
 */
public class Lambda_KB {
    private static final Logger logger = LogManager.getLogger(Lambda_KB.class);

    public static void main(String[] args) {
        Consumer<String> stringConsumer = getAnonymousConsumer();
        stringConsumer.accept("The anonymous message");

        stringConsumer = getLambdaConsumer();
        stringConsumer.accept("The lambda message");

        Method[] methods = Lambda_KB.class.getDeclaredMethods();
        for (Method method : methods) {
            logger.info(method);
        }
    }

    private static Consumer<String> getAnonymousConsumer() {
        return new Consumer<String>() {
            @Override
            public void accept(String s) {
                logger.info("Message NOT from lambda: {}", s);
            }
        };
    }

    private static Consumer<String> getLambdaConsumer() {
        return s -> logger.info("Message NOT from lambda: {}", s);
    }
}
