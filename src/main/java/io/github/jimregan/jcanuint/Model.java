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

import java.util.HashMap;
import java.util.Map;

public class Model {
    private Map<String, Score> words;
    private Map<String, Score> regexes;
    public Model() {
        this.words = new HashMap<String, Score>();
        this.regexes = new HashMap<String, Score>();
    }
    static String getSimpleString(String s) {
        if(s.charAt(0) == '^' && s.endsWith("[ ]")) {
            return s.substring(1, s.length() - 3);
        }
        return s;
    }
    private static boolean isRegexLike(String s) {
        return s.contains("(") || s.contains("?") || s.contains("[");
    }
    public void addWord(String w, String C, String M, String U) {
        words.put(w + " ", new Score(C, M, U));
    }
    public void addRegex(String w, String C, String M, String U) {
        regexes.put(w, new Score(C, M, U));
    }
    public void add(String w, String C, String M, String U) {
        if(getSimpleString(w).equals(w)) {
            addRegex(w, C, M, U);
        } else {
            addWord(w, C, M, U);
        }
    }
    public void add(String[] s) {
        add(s[0], s[1], s[2], s[3]);
    }
    public Score checkNGram(String s) {
        Score out = new Score();
        for(Map.Entry<String, Score> ws : words.entrySet()) {
            if(s.startsWith(ws.getKey())) {
                out.addScore(ws.getValue());
            }
        }
        for(Map.Entry<String, Score> re : regexes.entrySet()) {
            if(s.matches(re.getKey())) {
                out.addScore(re.getValue());
            }
        }
        return out;
    }
    public Score checkNGrams(String[] ngrams) {
        Score out = new Score();
        for(String ngram : ngrams) {
            out.addScore(checkNGram(ngram));
        }
        return out;
    }
}