package anchor.dataStrcutrue.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArrayStackTest {

    private final ArrayStack<String> stack = new ArrayStack<>(5);

    @BeforeEach
    void init() {
        stack.add("a");
        stack.add("b");
        stack.add("c");
        stack.add("d");
    }

    @Test
    void add() {
        assertEquals("[d,c,b,a]", stack.display());
        stack.add("e");
        assertEquals(5, stack.size());
        assertThrows(IndexOutOfBoundsException.class, () -> stack.add("f"));
    }

    @Test
    void pop() {
        assertEquals("d", stack.pop());
        stack.add("e");
        assertEquals("[e,c,b,a]", stack.display());
        assertEquals("e", stack.pop());
        assertEquals("c", stack.pop());
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
        assertThrows(IndexOutOfBoundsException.class, stack::pop);
    }
}