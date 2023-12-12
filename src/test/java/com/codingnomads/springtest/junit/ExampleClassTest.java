/* CodingNomads (C)2023 */
package com.codingnomads.springtest.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ExampleClassTest {

    @Test
    public void calculate() {
        assertEquals(290.4, ExampleClass.calculate(2.2, 3.3));
        assertNotEquals(290.3, ExampleClass.calculate(2.2, 3.3));
    }

    @Test
    public void concatDash() {
        assertEquals("this-is-expected", ExampleClass.concatDash("this", "is", "expected"));
    }
}
