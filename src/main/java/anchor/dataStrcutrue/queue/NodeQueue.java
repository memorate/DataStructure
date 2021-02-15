package anchor.dataStrcutrue.queue;

import anchor.dataStrcutrue.base.SingleNode;
import anchor.dataStrcutrue.base.SingleNode;

/**
 * @author Anchor
 *
 * 基于单链表实现队列
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

    /**
     * 入队
     *
     * @param item 入队的元素
     */
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

    /**
     * 出队
     *
     * 出队后会删除已出队的元素
     *
     * @return 出队的元素
     */
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

    /**
     * 以数组的格式展示队列中的值
     *
     * @return 例：[a,b,c,d]
     */
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
