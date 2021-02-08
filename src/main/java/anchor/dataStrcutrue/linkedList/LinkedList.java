package anchor.dataStrcutrue.linkedList;

/**
 * @author Anchor
 */
public class LinkedList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    public LinkedList() {
    }

    /**
     * 在链表尾部插入一个新值
     *
     * @param item 节点中的值
     * @return 操作成功返回 true
     */
    public boolean add(E item) {
        if (null == first) {
            Node<E> node = new Node<>(item, null, null);
            this.first = node;
            this.last = node;
        } else {
            final Node<E> n = last;
            Node<E> newNode = new Node<>(item, n, null);
            this.last = newNode;
            n.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * 在已存在的节点所在的位置插入新值
     *  例如：当 index 为 5 时，需要将原 index 为 5 及 5 之后的所有节点向后移一位，
     *       将 item 插入到 5 所在的节点
     *
     * @param index  下标，从 0 开始
     * @param item   待插入的值
     */
    public void add(int index, E item) {
        Node<E> node = getNode(index);
        Node<E> newNode = new Node<>(item, node.pre, node);
        node.pre.next = newNode;
        node.pre = newNode;
        size++;
    }

    /**
     * 修改下标所在节点中的值
     *
     * @param index  下标，从 0 开始
     * @param item   新值
     * @return 旧值
     */
    public E set(int index, E item) {
        Node<E> node = getNode(index);
        E old = node.item;
        node.item = item;
        return old;
    }

    /**
     * 删除链表尾部的节点
     *
     * @return 被删除节点的值
     */
    public E delete() {
        Node<E> oldLast = this.last;
        this.last = oldLast.pre;
        oldLast.pre.next = null;
        size--;
        return oldLast.item;
    }

    /**
     * 删除指定节点
     *
     * @param index  下标，从 0 开始
     * @return 被删除的值
     */
    public E delete(int index) {
        rangeCheck(index);
        Node<E> node = getNode(index);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
        return node.item;
    }

    /**
     * 根据下标来获取值
     *
     * @param index  下标，从 0 开始
     * @return 下标所指的值
     */
    public E get(int index) {
        return getNode(index).item;
    }

    /**
     * 获取链表中节点的个数
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * 根据下标来获取节点
     *
     * @param index  下标，从 0 开始
     * @return 下标所指的 Node
     */
    private Node<E> getNode(int index) {
        if (null == first) {
            throw new NullPointerException("LinkedList is empty!");
        }
        rangeCheck(index);
        Node<E> n;
        //根据 index 的位置来决定是顺序查还是逆序查
        if (index < size >> 1) {
            n = first;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
        } else {
            n = last;
            for (int i = size - 1; i > index; i--) {
                n = n.pre;
            }
        }
        return n;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    private static class Node<E> {
        private E item;
        private Node<E> pre;
        private Node<E> next;

        public Node(E item, Node<E> pre, Node<E> next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
}
