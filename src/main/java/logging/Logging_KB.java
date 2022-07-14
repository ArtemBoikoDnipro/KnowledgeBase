package logging;

import core.encoding.Encoding_KB;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.BiConsumer;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class Logging_KB {
    private static final Logger logger = LogManager.getLogger(Encoding_KB.class);

    public static BiConsumer<String, String> log = (message, obj) ->
            LogManager.getLogger().debug("{} = {}", message, obj);

    public static BiConsumer<String, String> getConsumer(Class<?> clazz) {
        return (message, obj) -> LogManager.getLogger(clazz).debug("{} = {}", message, obj);
    }

    public static void main(String[] args) {
        /*
        log4j2 configuration example:

        https://howtodoinjava.com/log4j2/log4j2-xml-configuration-example/
         */
        Log4j2 log4j2;

    }

    public static void log(Object... objects) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String callerClassName = stackTraceElements[2].getClassName();

        if (objects.length == 0) {
            throw new IllegalArgumentException("Empty logging objects.");
        }
        if (objects.length == 1) {
            LogManager.getLogger(callerClassName).debug(objects[0]);
        }
        if (objects.length == 2) {
            LogManager.getLogger(callerClassName).debug("{} = {}", objects[0], objects[1]);
        }
    }
}
