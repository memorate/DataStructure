package anchor.dataStrcutrue.array;

/**
 * @author Anchor
 *
 * 实现一个数组，应有五个方法：增、删、查、改、展示
 */
public class Array<E> {
    /**
     * Array 当前的大小
     */
    private int size;

    /**
     * Array 最多能容纳元素的个数，初始化时指定
     */
    private final int maxSize;

    /**
     * 使用链式存储来储存数据
     */
    private final Object[] data;

    public Array(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Array size can not less than 1!");
        } else {
            this.maxSize = maxSize;
            this.data = new Object[maxSize];
            this.size = 0;
        }
    }

    /**
     * 在 Array 末尾添加一个元素
     *
     * @param element  被添加的元素
     * @return 若 Array 已满，抛出 OutOfMemoryError；操作成功返回 true
     */
    public boolean add(E element) {
        rangeCheck(size + 1);
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
        rangeCheck(index);
        data[index] = element;
        return true;
    }

    /**
     * 获取 Array 尾部的元素
     *
     * @return 尾部的元素
     */
    public E get() {
        return element(size - 1);
    }

    /**
     * 根据索引来获取 Array 中的指定元素
     *
     * @param index   索引
     * @return 越界会抛出 IndexOutOfBoundsException
     */
    public E get(int index) {
        return element(index);
    }

    private E element(int index) {
        rangeCheck(index);
        return (E) data[index];
    }

    private void rangeCheck(int index) {
        if (size == 0 && index == 0) {
            throw new NullPointerException("Array is empty!");
        }
        if (index < 0 || index >= maxSize) {
            throw new IndexOutOfBoundsException("Index out of boundary!");
        }
    }
}
