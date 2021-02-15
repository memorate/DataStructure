package anchor.dataStrcutrue.stack;

/**
 * @author Anchor
 *
 * 基于数组实现栈
 */
public class ArrayStack<E> {

    private int size = 0;

    private final int capacity;

    private Object[] array;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public void add(E item) {
        full();
        array[size++] = item;
    }

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
