package anchor.dataStrcutrue.stack;

/**
 * @author Anchor
 *
 * 基于数组实现栈
 */
public class ArrayStack<E> {

    /**
     * 栈中当前元素的数量
     */
    private int size = 0;

    /**
     * 栈的容量，不会自动扩容或缩容
     */
    private final int capacity;

    /**
     * 使用数组来储存栈中元素
     */
    private Object[] array;

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can not less than 1!");
        }
        this.capacity = capacity;
        array = new Object[capacity];
    }

    /**
     * 入栈
     *
     * @param item 入栈的元素
     */
    public void add(E item) {
        full();
        array[size++] = item;
    }

    /**
     * 出栈
     *
     * 出栈后会删除已出栈的元素
     *
     * @return 出栈的元素
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        empty();
        int index = size - 1;
        E item = (E) array[index];
        array[index] = null;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
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
        empty();
        StringBuilder builder = new StringBuilder("[");
        for (int i = size - 1; i >= 0; i--) {
            builder.append(array[i]);
            if (i == 0) {
                return builder.append("]").toString();
            }
            builder.append(",");
        }
        return "";
    }

    private void full() {
        if (size == capacity) {
            throw new IndexOutOfBoundsException("Stack is full!");
        }
    }

    private void empty() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Stack is empty!");
        }
    }
}
