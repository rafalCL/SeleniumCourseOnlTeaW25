package pl.coderslab.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsExample {
    @Test
    public void firstRealTest() {
        // given
        int a = 2;
        int b = 40;
        // when
        int c = a + b;
        // then
        assertEquals(42, c);
        assertEquals("ala", "ala");
        assertEquals(42.42, 42.42, .01);
        Object o = new Object();
        assertSame(o, o);
        assertTrue(42 == 42);
        assertFalse(42 == 4242);
        assertNull(null);
    }
}
