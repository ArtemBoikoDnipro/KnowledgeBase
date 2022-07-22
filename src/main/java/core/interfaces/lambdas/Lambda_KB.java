package core.interfaces.lambdas;

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
        /* при вызове .accept вызывается private static method
        * поскольку мы использовали лямбду */
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

    /**
     * если меняем вызов анонимного метода на лямбду, то появляется:
     * private static synthetic lambda$
     *
     * когда мы используем лямбду, то компилятор добавляет
     * приватный статический метод (private static method)
     *
     * проверить это можно вызвав на объекте типа Class метод getDeclaredMethods()
     *
     * @return consumer object
     */
    private static Consumer<String> getLambdaConsumer() {
        return s -> logger.info("Message NOT from lambda: {}", s);
    }
}
