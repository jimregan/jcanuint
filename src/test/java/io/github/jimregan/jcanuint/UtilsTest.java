/*
 * MIT License
 *
 * Copyright (c) 2018 Jim O'Regan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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

    @Test
    public void join() {
        String[] inp = new String[]{"a", "simple", "test", "string"};
        String exp = "a simple test string";
        assertEquals(exp, Utils.join(inp));
    }
}