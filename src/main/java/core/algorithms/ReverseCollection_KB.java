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
        reverseViaCollections(list);


        logger.debug("---------------------------------------------------------");


        array = fillArray(AMOUNT_OF_ELEMENTS);
        reverseViaForLoop(array);


        logger.debug("---------------------------------------------------------");


        array = fillArray(AMOUNT_OF_ELEMENTS);
        reverseViaForLoopWithoutThirdVariable(array);


        logger.debug("---------------------------------------------------------");


        reverseStringArray();


        logger.debug("---------------------------------------------------------");


        reverseList();
    }

    private static void reverseList() {
        List<Object> strList = Arrays.asList("a", "b", "c");
        reverseList(strList);
        logger.debug(" array after reverse = {}", strList);
    }

    private static Integer[] fillArray(int amount) {
////        when fill with one value for every element
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


    private static void reverseViaCollections(List<Integer> list) {
        logger.debug("List before reverse = {}", list);
        long startTime = System.currentTimeMillis();
        Collections.reverse(list);
        long endTime = System.currentTimeMillis();

        logger.debug(" List after reverse = {}", list);
        logger.debug(" Execution duration (ms) = {}", (endTime - startTime));
    }


    private static void reverseViaForLoop(Integer[] array) {
        logger.debug("array before reverse = {}", Arrays.toString(array));
        long startTime = System.currentTimeMillis();

        reverse(array);

        long endTime = System.currentTimeMillis();
        logger.debug(" Execution duration (ms) = {}", (endTime - startTime));
        logger.debug(" array after reverse = {}", Arrays.toString(array));
    }

    private static void reverse(Object[] array) {
        for (int i = 0; i < array.length / 2; ++i) {
            Object temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }


    private static void reverseViaForLoopWithoutThirdVariable(Integer[] array) {
        logger.debug("array before reverse = {}", Arrays.toString(array));
        long startTime = System.currentTimeMillis();

        reverseWithoutThirdVariable(array);

        long endTime = System.currentTimeMillis();
        logger.debug(" Execution duration (ms) = {}", (endTime - startTime));
        logger.debug(" array after reverse = {}", Arrays.toString(array));
    }

    private static void reverseWithoutThirdVariable(Integer[] array) {
        for (int i = 0; i < array.length / 2; ++i) {
            array[i] = array[i] + array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i] - array[array.length - 1 - i];
            array[i] = array[i] - array[array.length - 1 - i];
        }
    }


    private static void reverseStringArray() {
        Object[] strArray = new String[]{"a", "b", "c"};
        reverse(strArray);
        logger.debug(" array after reverse = {}", Arrays.toString(strArray));
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
