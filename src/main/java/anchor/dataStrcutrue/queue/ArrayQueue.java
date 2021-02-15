package anchor.dataStrcutrue.queue;

/**
 * @author Anchor
 *
 * 基于数组实现队列
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
     * 队头，出队依赖队头
     */
    private int start;

    /**
     * 队尾，入队依赖队尾
     */
    private int end;

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can not less than 1!");
        }
        array = new Object[capacity];
        this.capacity = capacity;
        size = 0;
        start = 0;
        end = -1;
    }

    /**
     * 入队
     *
     * 当队尾到达数组尾部时，再重新从数组头部开始添加元素
     *
     * @param element 添加的元素
     */
    public void add(E element) {
        full();
        array[++end] = element;
        size++;
        if (size == capacity) {
            end = -1;
        }
    }

    /**
     * 出队
     *
     * 当队头到达数组尾部时，再重新从数组头部开始出队
     *
     * @return 出队的元素
     */
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

    /**
     * 展示实际是一次模拟所有元素出队的过程
     *
     * @return 以数组的格式返回队列中的元素，例：[a,b,c,d]
     */
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
