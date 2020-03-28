package array;

/**
 * 手撸一个动态数组（类似Java中的ArrayList）
 *
 * @author yanglbme
 * @date 2020/1/13
 */

@SuppressWarnings("unchecked")
public class DynamicArray<E> {
    /**
     * 数组大小
     */
    private int size;

    /**
     * 数组，用来存放元素
     */
    private E[] elements;

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 元素不存在的默认索引
     */
    private static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 带参构造方法（指定容量）
     *
     * @param capacity 容量
     */
    public DynamicArray(int capacity) {
        // 少于10则给它10
        capacity = capacity < 10 ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    /**
     * 无参构造方法
     */
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 获取数组大小
     *
     * @return 数组大小
     */
    public int size() {
        return size;
    }

    /**
     * 判断数组是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取指定索引位置的元素
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置指定索引位置的元素，并返回该索引位置原先的值
     *
     * @param index   位置
     * @param element 元素
     * @return 该位置旧的元素
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    /**
     * 判断是否包含某个元素
     *
     * @param element 元素
     * @return 是否包含
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 返回指定元素对应的索引位置
     *
     * @param element 元素
     * @return 元素索引
     */
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; ++i) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; ++i) {
                if (elements[i].equals(element)) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 移除指定索引位置的元素
     *
     * @param index 位置
     * @return 被移除的元素
     */
    public E remove(int index) {
        rangeCheck(index);
        E oldElement = elements[index];
        for (int i = index + 1; i < size; ++i) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;

        // 裁剪数组
        trim();

        return oldElement;
    }

    /**
     * 数组缩容
     */
    private void trim() {
        int capacity = elements.length;
        if (size >= (capacity >> 1) || capacity <= DEFAULT_CAPACITY) {
            // 不进行缩容
            return;
        }

        // 缩容
        int newCapacity = capacity >> 1;
        E[] newElements = (E[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;

    }

    /**
     * 清空数组
     */
    public void clear() {
        for (int i = 0; i < size; ++i) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 在尾部添加元素
     *
     * @param element 元素
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 在index位置添加元素
     *
     * @param index   位置
     * @param element 元素
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        // 确保容量至少有size+1个
        ensureCapacity(size + 1);

        for (int i = size - 1; i >= index; --i) {
            elements[i] = elements[i + 1];
        }
        elements[index] = element;
        ++size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; ++i) {
            sb.append(i == 0 ? "" : ", ").append(elements[i]);
        }
        sb.append("]");
        return "DynamicArray{" +
                "size=" + size +
                ", elements=" + sb.toString() +
                '}';
    }

    /**
     * 确保数组的容量至少为capacity
     *
     * @param capacity 容量下限
     */
    private void ensureCapacity(int capacity) {
        int len = elements.length;
        if (len >= capacity) {
            return;
        }
        int newCapacity = len + (len >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    /**
     * 检查索引是否越界(Add)
     *
     * @param index 索引
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    /**
     * 检查索引是否越界(非Add)
     *
     * @param index 索引
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /**
     * 抛索引越界异常
     *
     * @param index 索引
     */
    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("size=" + size + ", index=" + index);
    }
}
