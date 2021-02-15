package anchor.dataStrcutrue.base;

/**
 * @author Anchor
 *
 * 单向链表的节点
 */
public class SingleNode<E> {

    public E item;

    public SingleNode<E> node;

    public SingleNode(E item, SingleNode<E> node) {
        this.item = item;
        this.node = node;
    }
}
