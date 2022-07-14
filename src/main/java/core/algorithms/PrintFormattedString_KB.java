package core.algorithms;

import java.util.Arrays;

/**
 * Algorithm for printing data.
 *
 * @author Artem Boiko
 */
public class PrintFormattedString_KB {
    public static void main(String[] args) {
        String[] arg = {"1", "2", "3", "x", "5",
                        "6", "a", "baaaaaaaaaaa", "c", "10",
                        "11", "12", "13", "14", "15",
                        "16"};
        printFormatted(arg);
    }

    public static void printFormatted(String[] args) {
        int[] longestInColumns = new int[5];

        for (int i = 0; i < 5; i++) {
            longestInColumns[i] = getLongestInColumn(args, i);
        }
        System.out.println("longestInColumns = " + Arrays.toString(longestInColumns));

        for (int col = 0; col < args.length; col += 5) {
            for (int i = col; (i < col + 5) && i < args.length; i++) {
                System.out.print(args[i] + getSpace(longestInColumns[i - col]
                                                    - args[i].length()
                                                    + 4));
            }
            System.out.println();
        }
    }

    private static int getLongestInColumn(String[] args, int column) {
        int longest = args[column].length();
        for (int i = column; i < args.length; i += 5) {
            if (args[i].length() > longest) {
                longest = args[i].length();
                break;
            }
        }
        return longest;
    }

    private static String getSpace(int spacesAmount) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < spacesAmount; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }
}
