package anchor.dataStrcutrue.queue;

/**
 * @author Anchor
 */
public class ArrayQueue<E> {

    /**
     * 使用数组来存储元素
     */
    private final Object[] array;

    /**
     * 队列中现有元素的个数
     */
    private int size;

    /**
     * 队列的容量
     */
    private final int capacity;

    /**
     * 队列中元素在数组中的起始 index
     */
    private int start;

    /**
     * 队列中元素在数组中的结尾 index
     */
    private int end;

    public ArrayQueue(int capacity) {
        array = new Object[capacity];
        this.capacity = capacity;
        size = 0;
        start = 0;
        end = -1;
    }

    public void add(E element) {
        full();
        array[++end] = element;
        size++;
        if (size == capacity) {
            end = -1;
        }
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        empty();
        E target = (E) array[start];
        array[start] = null;
        start++;
        if (start == capacity - 1) {
            start = 0;
        }
        size--;
        return target;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String display() {
        int top = start;
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(array[top++]);
            if (top == capacity) {
                top = 0;
            }
            if (i == size - 1) {
                builder.append("]");
                break;
            }
            builder.append(",");
        }
        return builder.toString();
    }

    private void empty() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty!");
        }
    }

    private void full() {
        if (size == capacity) {
            throw new IndexOutOfBoundsException("Queue is full!");
        }
    }
}
