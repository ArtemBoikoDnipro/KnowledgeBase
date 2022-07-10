package core.algorithms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * Insertion Sort algorithm.
 * Алгоритм "сортировка вставками".
 *
 * @author Artem Boiko
 */
public class InsertionSort_KB {
    private static final Logger logger = LogManager.getLogger(InsertionSort_KB.class);

    public static void main(String[] args) {
        int[] array = {5, 2, 4, 6, 1};
        logger.debug("before = {}", Arrays.toString(array));

        insertionSort(array);
        logger.debug("sorted = {}", Arrays.toString(array));
    }

    static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            logger.debug("Outer iteration");
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                logger.debug("Inner iteration");
                int prev = array[j];
                if (prev > current) {
                    array[j + 1] = prev;
                    j--;
                }
                logger.debug("   to left = {}", Arrays.toString(array));
            }
            array[j + 1] = current;
            logger.debug("  to right = {}", Arrays.toString(array));
        }
    }
}
