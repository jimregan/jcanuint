package io.github.jimregan.jcanuint;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void simple_bigrams() {
        String[] exp = new String[]{"a ", "a simple", "simple test", "test string", "string "};
        String inp = "a simple test string";
        assertArrayEquals(exp, Utils.simple_bigrams(inp));
    }

    @Test
    public void simple_trigrams() {
        String[] exp = new String[]{"a ", "a simple ", "a simple test", "simple test string", "test string ", "string "};
        String inp = "a simple test string";
        assertArrayEquals(exp, Utils.simple_trigrams(inp));
    }
}