package anchor.dataStrcutrue.list;

/**
 * @author Anchor
 *
 * 实现一个数组，应有五个方法：增、删、查、改、展示
 */
public class ArrayList<E> {
    /**
     * Array 当前的大小
     */
    private int size;

    /**
     * Array 最多能容纳元素的个数，初始化时指定
     */
    private final int capacity;

    /**
     * 使用链式存储来储存数据
     */
    private final Object[] data;

    public ArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity can not less than 1!");
        }
        this.capacity = capacity;
        this.data = new Object[capacity];
        this.size = 0;
    }

    /**
     * 在 Array 末尾添加一个元素
     *
     * @param element  被添加的元素
     * @return 若 Array 已满，抛出 OutOfMemoryError；操作成功返回 true
     */
    public boolean add(E element) {
        outOfBoundary(size);
        data[size++] = element;
        return true;
    }

    /**
     * 新增/修改 Array 中指定的元素
     *
     * @param index     Array 的下表
     * @param element   待添加的元素
     * @return 越界会抛出 IndexOutOfBoundsException；操作成功返回 true
     */
    public boolean set(int index, E element) {
        outOfBoundary(index);
        data[index] = element;
        return true;
    }

    /**
     * 获取 Array 尾部的元素
     *
     * @return 尾部的元素
     */
    public E get() {
        return getElement(size - 1);
    }

    /**
     * 根据索引来获取 Array 中的指定元素
     *
     * @param index   索引
     * @return 越界会抛出 IndexOutOfBoundsException
     */
    public E get(int index) {
        return getElement(index);
    }

    /**
     * 删除 Array 尾部元素
     *
     * @return 被删除的元素
     */
    public E delete() {
        return removeElement(size - 1);
    }

    /**
     * 删除 Array 中指定 index 的元素
     *
     * @param index Array 下标
     * @return Array 为空会抛出 NullPointerException；
     *         index 越界会抛出 IndexOutOfBoundsException；
     *         成功会返回被删除的元素
     */
    public E delete(int index) {
        return removeElement(index);
    }

    public String display() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; ; i++) {
            builder.append(data[i]);
            if (i == size - 1) {
                return builder.append("]").toString();
            }
            builder.append(",");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void outOfBoundary(int index) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("Index out of boundary!");
        }
    }

    private void checkRangeAndEmpty(int index) {
        outOfBoundary(index);
        if (isEmpty()) {
            throw new NullPointerException("Array is empty!");
        }
    }

    @SuppressWarnings("unchecked")
    private E getElement(int index) {
        checkRangeAndEmpty(index);
        return (E) data[index];
    }

    @SuppressWarnings("unchecked")
    private E removeElement(int index) {
        checkRangeAndEmpty(index);
        E oldValue = (E) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        //清除尾部元素，使 GC 进行垃圾回收
        data[--size] = null;
        return oldValue;
    }
}
