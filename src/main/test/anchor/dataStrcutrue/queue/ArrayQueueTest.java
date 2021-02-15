package anchor.dataStrcutrue.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    private ArrayQueue<String> queue = new ArrayQueue<>(5);

    @BeforeEach
    void init() {
        queue.push("a");
        queue.push("b");
        queue.push("c");
        queue.push("d");
    }

    @Test
    void push() {
        queue.push("e");
        assertEquals(5, queue.size());
        assertThrows(IndexOutOfBoundsException.class, () -> queue.push("f"));
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
        queue.push("e");
        assertEquals("[a,b,c,d,e]", queue.display());
        queue.pop();
        assertEquals("[b,c,d,e]", queue.display());
        queue.push("f");
        assertEquals("[b,c,d,e,f]", queue.display());
    }
}