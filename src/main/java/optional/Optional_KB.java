package optional;

import java.util.Optional;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class Optional_KB {
    public static void main(String[] args) {
        Integer result = getNumber();
        System.out.println("result = " + result);
    }

    public static Integer getNumber() {
        Integer integer1 = 7;
        Integer integer2 = null;
        return Optional.ofNullable(integer1).orElseGet(Optional_KB::someOtherMethod);
    }

    public static Integer someOtherMethod() {
        return 5;
    }
}
