package anchor.dataStrcutrue.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayTest {

    private final Array<String> array = new Array<>(5);

    @BeforeEach
    void setUp() {
        array.add("a");
        array.add("b");
        array.add("c");
        array.add("d");
    }

    @Test
    void add() {
        array.add("e");
        assertEquals(5, array.size());
    }

    @Test
    void addOob() {
        array.add("e");
        assertThrows(IndexOutOfBoundsException.class, () -> array.add("f"));
    }

    @Test
    void set() {
        array.add("e");
        assertEquals("e", array.get(4));
        array.set(4, "x");
        assertEquals("x", array.get(4));
    }

    @Test
    void setInvalid() {
        assertThrows(IndexOutOfBoundsException.class, () -> array.set(-1, "x"));
    }

    @Test
    void delete() {
        array.add("e");
        array.delete();
        assertEquals(4, array.size());
        assertEquals("d", array.get());
    }

    @Test
    void deleteIndex() {
        array.delete(0);
        System.out.println(array.display());
        assertEquals(3, array.size());
    }


}