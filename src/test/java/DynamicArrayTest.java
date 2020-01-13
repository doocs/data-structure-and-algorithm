import io.github.doocs.array.DynamicArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 动态数组单元测试类
 *
 * @author yanglbme
 * @date 2020/1/13
 */

public class DynamicArrayTest {
    private DynamicArray<Integer> dynamicArray = new DynamicArray<>(2);

    @Test
    public void test() {
        dynamicArray.add(1); // [1]
        dynamicArray.add(2); // [1, 2]
        dynamicArray.add(3); // [1, 2, 3]
        assertEquals(3, dynamicArray.size());
        assertEquals(2, dynamicArray.get(1));
        assertEquals(1, dynamicArray.remove(0)); // [2, 3]
        assertEquals(2, dynamicArray.size());
        assertEquals(2, dynamicArray.set(0, 10)); // [10, 3]
        assertFalse(dynamicArray.isEmpty());
        dynamicArray.clear(); // []
        assertTrue(dynamicArray.isEmpty());
        dynamicArray.add(99); // [99]
        dynamicArray.add(100); // [99, 100]
        assertEquals(1, dynamicArray.indexOf(100));
        assertTrue(dynamicArray.contains(99));
        assertFalse(dynamicArray.contains(98));

    }

}
