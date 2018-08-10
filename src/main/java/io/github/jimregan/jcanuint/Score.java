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

public class Score {
    private double C;
    private double M;
    private double U;

    public double getM() {
        return M;
    }

    public void setM(double m) {
        M = m;
    }

    public double getC() {
        return C;
    }

    public void setC(double c) {
        C = c;
    }

    public double getU() {
        return U;
    }

    public void setU(double u) {
        U = u;
    }

    public boolean isZero() {
        return (M == C && C == U && U == 0.0);
    }

    public String getWinningDialect() {
        if(C >= M && C >= U) {
            return "C";
        } else if(M > C && M >= U) {
            return "M";
        } else {
            return "U";
        }
    }
    public double getScore(String dialect) {
        if("C".equalsIgnoreCase(dialect)) {
            return C;
        } else if("M".equalsIgnoreCase(dialect)) {
            return M;
        } else if("U".equalsIgnoreCase(dialect)) {
            return U;
        } else {
            return 0.0;
        }
    }
    public Score() {
        this.M = 0.0;
        this.C = 0.0;
        this.U = 0.0;
    }
    public Score(double C, double M, double U) {
        this.M = M;
        this.C = C;
        this.U = U;
    }
    public Score(String C, String M, String U) {
        this.M = Double.parseDouble(M);
        this.C = Double.parseDouble(C);
        this.U = Double.parseDouble(U);
    }
}
