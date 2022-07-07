package core.algorithms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Reversing/inverting of a collection with calculation time comparing.
 * Инвертирование коллекции и сравнение скорости работы.
 *
 * @author Artem Boiko
 */
public class ReverseCollection_KB {
    private static final Logger logger = LogManager.getLogger(ReverseCollection_KB.class);

    private static final int AMOUNT_OF_ELEMENTS = 10;

    public static void main(String[] args) {
        Integer[] array = fillArray(AMOUNT_OF_ELEMENTS);
        List<Integer> list = Arrays.asList(array);
        logger.debug("List before reverse = {}", list);

        long startTime = System.currentTimeMillis();
        Collections.reverse(list);
        long endTime = System.currentTimeMillis();

        logger.debug(" List after reverse = {}", list);
        logger.debug(" Execution duration (ms) = {}", (endTime - startTime));


        logger.debug("---------------------------------------------------------");


        array = fillArray(AMOUNT_OF_ELEMENTS);
        logger.debug("array before reverse = {}", Arrays.toString(array));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length / 2; ++i) {
            Integer temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        endTime = System.currentTimeMillis();

        logger.debug(" List after reverse = {}", list);
        logger.debug(" Execution duration (ms) = {}", (endTime - startTime));


        logger.debug(" array after reverse = {}", Arrays.toString(array));


        logger.debug("---------------------------------------------------------");


        array = fillArray(AMOUNT_OF_ELEMENTS);
        logger.debug("array before reverse = {}", Arrays.toString(array));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length / 2; ++i) {
            array[i] = array[i] + array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i] - array[array.length - 1 - i];
            array[i] = array[i] - array[array.length - 1 - i];
        }
        endTime = System.currentTimeMillis();

        logger.debug(" array after reverse = {}", Arrays.toString(array));
        logger.debug(" Execution duration (ms) = {}", (endTime - startTime));


        logger.debug("---------------------------------------------------------");


        Object[] strArray = new String[]{"a", "b", "c"};
        reverseArray(strArray);
        logger.debug(" array after reverse = {}", Arrays.toString(strArray));

        List<Object> strList = Arrays.asList("a", "b", "c");

        reverseList(strList);
        logger.debug(" array after reverse = {}", strList);


        logger.debug("---------------------------------------------------------");
    }

    private static Integer[] fillArray(int amount) {
//        when fill with one value for every element
//        Integer[] array = new Integer[amount];
//        Arrays.fill(array, 0, array.length, getRandomNumber(1, 2_000_000));

        Integer[] array = new Integer[amount];
        for (int i = 0; i < array.length; ++i) {
            array[i] = getRandomNumber(1, 20);
        }
        return array;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void reverseArray(Object[] array) {
        int size = array.length;
        for (int i = 0; i < size / 2; ++i) {
            Object temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
    }

    public static void reverseList(List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; ++i) {
            Object temp = list.get(i);
            Object end = list.get(size - 1 - i);
            list.set(i, end);
            list.set(size - 1 - i, temp);
        }
    }

    public static <T> void reverseGenericList(List<T> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; ++i) {
            T temp = list.get(i);
            T end = list.get(size - 1 - i);
            list.set(i, end);
            list.set(size - 1 - i, temp);
        }
    }

    public static void reverseGenericListSuper(List<? super Object> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; ++i) {
            Object temp = list.get(i);
            Object end = list.get(size - 1 - i);
            list.set(i, end);
            list.set(size - 1 - i, temp);
        }
    }
}
