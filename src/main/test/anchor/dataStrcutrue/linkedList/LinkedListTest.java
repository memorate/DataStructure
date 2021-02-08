package anchor.dataStrcutrue.linkedList;

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
    }

    @Test
    void set() {
    }

    @Test
    void delete() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void get() {
    }

    @Test
    void size() {
    }

    @Test
    void display() {
    }
}