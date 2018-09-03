package com.hiuk.test.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaticMethodTest {

    @Test
    void add() {
        assertEquals(10, StaticMethod.add(5,5));
        assertNotEquals(15, StaticMethod.add(10,10));
    }

    @Test
    void multiple() {
        assertNotEquals(1, StaticMethod.multiple(100,1000));
        assertEquals(100, StaticMethod.multiple(10,10));
    }
}