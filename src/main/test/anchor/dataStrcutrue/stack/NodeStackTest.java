package anchor.dataStrcutrue.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeStackTest {

    private final NodeStack<String> stack = new NodeStack<>();

    @BeforeEach
    void init() {
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
    }

    @Test
    void push() {
        assertEquals("[d,c,b,a]", stack.display());
        stack.push("e");
        assertEquals(5, stack.size());
        assertEquals("[e,d,c,b,a]", stack.display());
    }

    @Test
    void pop() {
        assertEquals("d", stack.pop());
        stack.push("e");
        assertEquals("[e,c,b,a]", stack.display());
        assertEquals("e", stack.pop());
        assertEquals("c", stack.pop());
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
        assertThrows(IndexOutOfBoundsException.class, stack::pop);
        assertEquals(0, stack.size());
    }
}