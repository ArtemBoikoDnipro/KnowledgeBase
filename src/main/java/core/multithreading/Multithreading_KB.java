package core.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Multithreading.
 *
 * @author Artem Boiko
 */
public class Multithreading_KB {
    private static final Logger logger = LogManager.getLogger(Multithreading_KB.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("Hello from main thread: {}", Thread.currentThread().getName());

        Runnable logic = () -> {
            logger.info("Hello from: {}", Thread.currentThread().getName());
            logger.info("     State: {}", Thread.currentThread().getState());
        };

        Thread thread = new Thread(logic);
        logger.info("     State: {}", thread.getState());

        thread.start();
        TimeUnit.SECONDS.sleep(1);
        logger.info("     State: {}", thread.getState());
    }
}
