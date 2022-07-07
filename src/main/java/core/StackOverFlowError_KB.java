package core;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class StackOverFlowError_KB {
    public static void main(String[] args) {
        int[] aaa = new int[]{1, 2, 3};
        doNotCallThisMethod(10);
    }

    public static int doNotCallThisMethod(int i) {
//        doNotCallThisMethod(args);
        return i * doNotCallThisMethod(i - 1);
    }
}
