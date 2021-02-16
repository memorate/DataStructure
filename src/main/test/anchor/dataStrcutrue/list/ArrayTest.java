package anchor.dataStrcutrue.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayTest {

    private final ArrayList<String> array = new ArrayList<>(5);

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

    @Test
    void deleteOob() {
        array.delete();
        array.delete();
        array.delete();
        array.delete();
        assertThrows(IndexOutOfBoundsException.class, array::delete);
    }

    @Test
    void get() {
        assertEquals("d", array.get());
    }

    @Test
    void getIndex() {
        assertEquals("b", array.get(1));
    }

    @Test
    void getOob() {
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(-2));
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(10));
    }

    @Test
    void size() {
        assertEquals(4, array.size());
        array.add("e");
        assertEquals(5, array.size());
    }

    @Test
    void display() {
        assertEquals("[a,b,c,d]", array.display());
        array.add("e");
        assertEquals("[a,b,c,d,e]", array.display());
    }
}