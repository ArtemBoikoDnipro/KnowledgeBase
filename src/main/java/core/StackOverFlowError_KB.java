package core;

/**
 * StackOverFlowError provoke.
 *
 * @author Artem Boiko
 */
public class StackOverFlowError_KB {
    public static void main(String[] args) {
        doNotCallThisMethod(10);
    }

    public static int doNotCallThisMethod(int i) {
        return i * doNotCallThisMethod(i - 1);
    }
}
