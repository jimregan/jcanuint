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

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    static String[] simple_bigrams(String s) {
        ArrayList<String> buf = new ArrayList<String>();
        String[] tokens = s.split("\\s+");
        for(int i = 0, j = 1; j < tokens.length; i++, j++) {
            if(i == 0) {
                buf.add(tokens[0] + " ");
                buf.add(tokens[0] + " " + tokens[1]);
            } else if(j == tokens.length - 1) {
                buf.add(tokens[i] + " " + tokens[j]);
                buf.add(tokens[tokens.length - 1] + " ");
            } else {
                buf.add(tokens[i] + " " + tokens[j]);
            }
        }
        return buf.toArray(new String[0]);
    }
    static String[] simple_trigrams(String s) {
        ArrayList<String> buf = new ArrayList<String>();
        String[] tokens = s.split("\\s+");
        for(int i = 0, j = 1, k = 2; k < tokens.length; i++, j++, k++) {
            if(i == 0) {
                buf.add(tokens[0] + " ");
                buf.add(tokens[0] + " " + tokens[1] + " ");
                buf.add(tokens[0] + " " + tokens[1] + " " + tokens[2]);
            } else if(k == tokens.length - 1) {
                buf.add(tokens[i] + " " + tokens[j] + " " + tokens[k]);
                buf.add(tokens[j] + " " + tokens[k] + " ");
                buf.add(tokens[k] + " ");
            } else {
                buf.add(tokens[i] + " " + tokens[j] + " " + tokens[k]);
            }
        }
        return buf.toArray(new String[0]);
    }
    static String join(String[] s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length - 1; i++) {
            sb.append(s[i]);
            sb.append(" ");
        }
        sb.append(s[s.length - 1]);
        return sb.toString();
    }
    static String[] slurpFile(InputStreamReader isr) throws Exception {
        List<String> buf = new ArrayList<String>();
        BufferedReader br = new BufferedReader(isr);
        String line;
        while((line = br.readLine()) != null) {
            if(!"".equals(line)) {
                buf.add(line);
            }
        }
        return buf.toArray(new String[0]);
    }
    static String[] slurpFile(InputStream is) throws Exception {
        return slurpFile(new InputStreamReader(is));
    }
    static String[] slurpFile(FileInputStream is) throws Exception {
        return slurpFile(new InputStreamReader(is));
    }
    static String[] slurpFile(File f) throws Exception {
        return slurpFile(new FileInputStream(f));
    }

}
