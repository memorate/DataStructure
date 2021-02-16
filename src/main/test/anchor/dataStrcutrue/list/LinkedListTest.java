package anchor.dataStrcutrue.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {

    private final LinkedList<String> list = new LinkedList<>();

    @BeforeEach
    void setUp() {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
    }

    @Test
    void add() {
        list.add("e");
        assertEquals("a", list.getFirst());
        assertEquals("e", list.getLast());
        assertEquals(5, list.size());
    }

    @Test
    void testAdd() {
        list.add(1, "x");
        assertEquals(5, list.size());
        assertEquals("x", list.get(1));
    }

    @Test
    void set() {
        list.set(1, "x");
        assertEquals(4, list.size());
        assertEquals("x", list.get(1));
    }

    @Test
    void delete() {
        list.delete();
        assertEquals(3, list.size());
        assertEquals("c", list.getLast());
    }

    @Test
    void testDelete() {
        list.delete(1);
        assertEquals(3, list.size());
        assertEquals("c", list.get(1));
    }

    @Test
    void display() {
        System.out.println(list.display());
        assertEquals("[a,b,c,d]", list.display());
    }
}