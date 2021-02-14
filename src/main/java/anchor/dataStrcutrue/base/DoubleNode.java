package anchor.dataStrcutrue.base;

/**
 * @author Anchor
 *
 * 双向链表的节点
 */
public class DoubleNode<E> {

    public E item;

    public DoubleNode<E> pre;

    public DoubleNode<E> next;

    public DoubleNode(E item, DoubleNode<E> pre, DoubleNode<E> next) {
        this.item = item;
        this.pre = pre;
        this.next = next;
    }
}
