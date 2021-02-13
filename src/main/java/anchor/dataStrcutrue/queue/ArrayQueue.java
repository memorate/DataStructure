package anchor.dataStrcutrue.queue;

/**
 * @author Anchor
 */
public class ArrayQueue<E> {

    /**
     * 使用数组来存储元素
     */
    private Object[] array;

    /**
     * 队列中现有元素的个数
     */
    private int size;

    /**
     * 队列的容量
     */
    private int capacity;

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
        start = -1;
        end = 0;
    }

    public void add(E element) {
        full();
        if (size == 0) {
            array[start] = element;
            size++;
            return;
        }
        if (end < capacity - 1) {

        }
    }

    private void full() {
        if (size == capacity) {
            throw new IndexOutOfBoundsException("Queue is full!");
        }
    }
}
