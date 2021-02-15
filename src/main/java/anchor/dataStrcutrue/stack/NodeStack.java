package anchor.dataStrcutrue.stack;

import anchor.dataStrcutrue.base.SingleNode;

/**
 * @author Anchor
 *
 * 基于反向单链表实现栈
 */
public class NodeStack<E> {

    /**
     * 栈中当前元素的数量
     */
    private int size;

    /**
     * 尾结点
     */
    private SingleNode<E> last;

    /**
     * 入栈
     *
     * @param item 入栈的元素
     */
    public void add(E item) {
        if (null == last) {
            last = new SingleNode<>(item, null);
        } else {
            last = new SingleNode<>(item, last);
        }
        size++;
    }

    /**
     * 出栈
     *
     * 出栈后出栈的元素会被删除
     *
     * @return 出栈的元素
     */
    public E pop() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Stack is empty!");
        }
        E item = last.item;
        last.item = null;
        last = last.node;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    /**
     * 以数组的格式展示栈中的所有元素，实际上是模拟一次所有元素出栈的过程
     *
     * @return 例：[a,b,c,d]
     */
    public String display() {
        SingleNode<E> node = last;
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(node.item);
            if (i == size - 1) {
                return builder.append("]").toString();
            }
            builder.append(",");
            node = node.node;
        }
        return "";
    }
}
