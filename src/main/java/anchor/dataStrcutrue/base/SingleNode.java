package anchor.dataStrcutrue.base;

/**
 * @author Anchor
 *
 * 单向链表的节点
 */
public class SingleNode<E> {

    public E item;

    public SingleNode<E> next;

    public SingleNode(E item, SingleNode<E> next) {
        this.item = item;
        this.next = next;
    }
}
