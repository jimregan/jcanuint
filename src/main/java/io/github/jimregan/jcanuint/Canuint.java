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

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Canuint {
    public static void main (String[] args) throws Exception {
        Model mdl = ModelData.getModel();
        if(mdl == null) {
            System.err.println("Failed to load model");
            System.exit(1);
        }
        if(args.length != 2) {
            System.err.println("Please specify file to read from");
            System.exit(1);
        }
        InputStream is;
        if(args[1].equals("-")) {
            is = System.in;
        } else {
            is = new FileInputStream(new File(args[1]));
        }
        String[] input = Utils.slurpFile(is);
        Score out = mdl.checkTokens(input);
        System.out.println(out.getResult());
    }
}
