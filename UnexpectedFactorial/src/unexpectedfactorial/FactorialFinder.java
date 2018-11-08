package unexpectedfactorial;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tim Barber
 */
public class FactorialFinder {

    private String usrText;
    ArrayList<Integer> nums = new ArrayList();

    public static String solve(String userText) {
        String output = "";
        Scanner chop = new Scanner(userText);
        while (chop.hasNext()) {
            String token = chop.next();
            if (token.replaceAll("!", "").length() != token.length()) {
                //contains "!"
                int firstIndex = token.indexOf("!");
                if (firstIndex > 0 && Character.isDigit(token.charAt(firstIndex - 1))) {
                    String newToken = token.replaceAll("[a-zA-Z]", "");
                    //replace all letters with nothing
                    int newNum = factorial(newToken);
                    output += newNum;
                } else {
                    output += token;
                }
            } else {
                output += token;
            }
        }
        return output.toString();
    }

    public static int factorial(String num) {
        if (num.charAt(num.length() - 1) == '!') { // remove exclamation mark if necessary
            num = num.substring(0, num.length() - 1);
        }
        int total = 1;
        for (int i = 1; i <= Integer.valueOf(num); i++) {
            total *= i;
        }
        return total;
    }

    public static int factorial(int num) {
        int total = 1;
        for (int i = 1; i <= num; i++) {
            total *= i;
        }
        return total;
    }
}

/*
 * The MIT License
 *
 * Copyright 2018 barber.timothy20.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
