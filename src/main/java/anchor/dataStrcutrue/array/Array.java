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
     * 用于存储数据
     */
    private final Object[] data;

    public Array(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Array size can not less than 1!");
        } else {
            this.maxSize = maxSize;
            this.data = new Object[maxSize];
        }
    }

    /**
     * 在 Array 末尾添加一个元素
     * @param element  被添加的元素
     * @return 若 Array 已满，抛出 OutOfMemoryError; 操作成功返回 true
     */
    public boolean add(E element) {
        if (size + 1 > maxSize) {
            throw new OutOfMemoryError("Array can't afford another element anymore!");
        } else {
            data[size++] = element;
            return true;
        }
    }

    /**
     * 新增/修改 指定 Array 中下标所在的值
     * @param index
     * @param element
     * @return
     */
    public boolean set(int index, E element) {
        if (index < 0 || index > maxSize) {
            throw new IndexOutOfBoundsException("index can not out of boundary!");
        } else {
            data[index] = element;
            return true;
        }
    }
}
