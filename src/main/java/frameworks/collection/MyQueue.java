package frameworks.collection;

import java.util.Queue;

/**
 * // TODO add some description
 *
 * @author Artem Boiko
 */
public class MyQueue {
    /**
     * A collection designed for holding elements prior to processing.
     * <p>
     * Each Queue methods exists in two forms: <br>
     * one throws an exception if the operation fails, <br>
     * the other returns a special value <br>
     * (either {@code null} or {@code false}, depending on the operation).
     * <p>
     * The latter form of the insert operation is designed specifically <br>
     * for use with capacity-restricted {@code Queue} implementations; <br>
     * in most implementations, insert operations cannot fail.
     *<p>
     * <table BORDER CELLPADDING=3 CELLSPACING=1>
     * <caption>Queue methods</caption>
     *  <tr>
     *    <td></td>
     *    <td ALIGN=CENTER><em>Throws exception</em></td>
     *    <td ALIGN=CENTER><em>|</em></td>
     *    <td ALIGN=CENTER><em>Returns special value</em></td>
     *  </tr>
     *  <tr>
     *    <td><b>Insert</b></td>
     *    <td>{@link Queue#add add(e)}</td>
     *    <td>|</td>
     *    <td>{@link Queue#offer offer(e)}</td>
     *  </tr>
     *  <tr>
     *    <td><b>Remove</b></td>
     *    <td>{@link Queue#remove remove()}</td>
     *    <td>|</td>
     *    <td>{@link Queue#poll poll()}</td>
     *  </tr>
     *  <tr>
     *    <td><b>Examine</b></td>
     *    <td>{@link Queue#element element()}</td>
     *    <td>|</td>
     *    <td>{@link Queue#peek peek()}</td>
     *  </tr>
     * </table>
     */
    Queue<?> queue;

    public static void main(String[] args) {
        /*
         * public interface Queue<E> extends Collection<E> {...}
         *
         *           Throws exception  |  Returns special value
         *  Insert  boolean add(E e);  |  boolean offer(E e);
         *  Remove        E remove();  |        E poll();
         * Examine        E element(); |        E peek();
         */


    }
}
