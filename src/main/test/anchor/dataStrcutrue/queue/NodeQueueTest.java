package anchor.dataStrcutrue.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NodeQueueTest {

    private final NodeQueue<String> queue = new NodeQueue<>();

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
        queue.push("f");
        assertEquals("[a,b,c,d,e,f]", queue.display());
    }

    @Test
    void pop() {
        assertEquals("a", queue.pop());
        assertEquals(3, queue.size());
        queue.push("e");
        assertEquals("[b,c,d,e]", queue.display());
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        assertThrows(IndexOutOfBoundsException.class, queue::pop);
    }
}