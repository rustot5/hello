package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {
    private final Hello unit = new Hello();

    @Test
    public void testDoIt() {
        assertEquals(Utils.HELLO_MESSAGE, unit.doIt());
    }
}
