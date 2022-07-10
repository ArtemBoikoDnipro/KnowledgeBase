package core.algorithms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * Bubble Sort algorithm.
 * <br>
 * Алгоритм "сортировка пузырьком".
 *
 * @author Artem Boiko
 */
public class BubbleSort_KB {
    private static final Logger logger = LogManager.getLogger(BubbleSort_KB.class);

    public static void main(String[] args) {
        Integer[] array = {5, 2, 4, 6, 1};
        logger.debug("before = {}", Arrays.toString(array));

        bubbleSort(array);
        logger.debug("sorted = {}", Arrays.toString(array));
    }

    public static void bubbleSort(Integer[] array) {
        for (int j = 0; j < array.length; j++) {
            logger.debug("Outer iteration");
            for (int i = 0; i < array.length - j - 1; i++) {
                logger.debug("Inner iteration");
                Integer temp = array[i];
                if (temp > array[i + 1]) {
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    logger.debug("  replaced = {}", Arrays.toString(array));
                }
            }
        }
    }
}
