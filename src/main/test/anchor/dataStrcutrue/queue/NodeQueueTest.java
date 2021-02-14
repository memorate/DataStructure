package anchor.dataStrcutrue.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NodeQueueTest {

    private final NodeQueue<String> queue = new NodeQueue<>();

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
        queue.add("f");
        assertEquals("[a,b,c,d,e,f]", queue.display());
    }

    @Test
    void pop() {
        assertEquals("a", queue.pop());
        assertEquals(3, queue.size());
        queue.add("e");
        assertEquals("[b,c,d,e]", queue.display());
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        assertThrows(IndexOutOfBoundsException.class, queue::pop);
    }
}