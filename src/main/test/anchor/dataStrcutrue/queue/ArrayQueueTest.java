package anchor.dataStrcutrue.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    private ArrayQueue<String> queue = new ArrayQueue<>(5);

    @BeforeEach
    void init() {
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
    }

    @Test
    void add() {
        queue.add("e");
        assertEquals(5, queue.size());
        assertThrows(IndexOutOfBoundsException.class, () -> queue.add("f"));
    }

    @Test
    void pop() {
        assertEquals(4, queue.size());
        assertEquals("a", queue.pop());
        queue.pop();
        queue.pop();
        assertEquals("d", queue.pop());
        assertTrue(queue.isEmpty());
        assertThrows(IndexOutOfBoundsException.class, queue::pop);
    }

    @Test
    void display() {
        assertEquals("[a,b,c,d]", queue.display());
        queue.add("e");
        assertEquals("[a,b,c,d,e]", queue.display());
        queue.pop();
        assertEquals("[b,c,d,e]", queue.display());
        queue.add("f");
        assertEquals("[b,c,d,e,f]", queue.display());
    }
}