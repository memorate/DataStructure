package anchor.dataStrcutrue.queue;

import anchor.dataStrcutrue.base.SingleNode;
import anchor.dataStrcutrue.base.SingleNode;

/**
 * @author Anchor
 *
 * 基于链表实现队列
 */
public class NodeQueue<E> {

    /**
     * 当前队列中元素的个数
     */
    private int size;

    /**
     * 头结点
     */
    private SingleNode<E> first;

    /**
     * 尾节点
     */
    private SingleNode<E> last;

    public void add(E item) {
        if (size == 0) {
            first = new SingleNode<>(item, null);
        } else {
            if (null == last) {
                last = new SingleNode<>(item, null);
                first.next = last;
            } else {
                SingleNode<E> node = new SingleNode<>(item, null);
                last.next = node;
                last = node;
            }
        }
        size++;
    }

    public E pop() {
        if (size == 0){
            throw new IndexOutOfBoundsException("Queue is empty!");
        }
        E element = first.item;
        first.item = null;
        first = first.next;
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public String display() {
        StringBuilder builder = new StringBuilder("[");
        SingleNode<E> node = first;
        for (int i = 0; i < size; i++) {
            builder.append(node.item);
            if (i == size - 1) {
                builder.append("]");
            } else {
                builder.append(",");
            }
            node = node.next;
        }
        return builder.toString();
    }
}
