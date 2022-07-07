package util;

import org.apache.logging.log4j.LogManager;

import java.util.Arrays;
import java.util.Objects;

/**
 * Util class for closing objects that implements AutoCloseable interface.
 *
 * @author Artem Boiko
 */
public class Closer_KB {
    /**
     * Closes all AutoCloseable objects.
     *
     * @param objects objects to be closed
     * @throws IllegalStateException when cannot close the object
     */
    public static void close(AutoCloseable... objects) {
        Arrays.stream(objects)
              .filter(Objects::nonNull)
              .forEach(object -> {
                  try {
                      object.close();
                  } catch (Exception e) {
                      LogManager.getLogger(Closer_KB.class).error("Cannot close {}", object);
                  }
              });
    }
}
