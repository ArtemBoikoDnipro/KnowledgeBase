package core.lambdas;

import org.apache.logging.log4j.LogManager;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
@FunctionalInterface
public interface VarargsConsumer<T, U> {
    void accept(T t, U u);

    default void accept(T t) {
        LogManager.getLogger(this.getClass().getEnclosingClass()).debug(t);
    }
}
