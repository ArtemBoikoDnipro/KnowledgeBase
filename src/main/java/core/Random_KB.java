package core;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class Random_KB {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 7);
        int randomInt = getRandomFrom(list);
        System.out.println("randomInt = " + randomInt);
    }

    /**
     * Randomizes restricted values.
     * Выдаёт рандомное число из тех, что мы задали (из тех, что у нас есть).
     */
    public static Integer getRandomFrom(List<Integer> list) {
        int index = ThreadLocalRandom.current().nextInt(list.size());
        return list.get(index);
    }
}
