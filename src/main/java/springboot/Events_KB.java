package springboot;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class Events_KB {
    public static void main(String[] args) {
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("code");
    }
}
