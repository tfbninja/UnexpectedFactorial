package unexpectedfactorial;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tim Barber
 */
public class FactorialFinder {

    private String usrText;
    ArrayList<Integer> nums = new ArrayList();
    private static DecimalFormat df = new DecimalFormat("#");

    static {
        df.setMaximumFractionDigits(0);
    }

    public static String solve(String userText) {
        String output = "";
        Scanner chop = new Scanner(userText);
        while (chop.hasNextLine()) {
            Scanner line = new Scanner(chop.nextLine());
            tokenprocessor:
            while (line.hasNext()) {
                String token = line.next();
                if (token.replaceAll("!", "").length() != token.length()) {
                    //contains "!"
                    int firstIndex = token.indexOf("!");
                    if (firstIndex > 0 && Character.isDigit(token.charAt(firstIndex - 1))) {
                        //now check it isn't within a word
                        for (char i : token.toCharArray()) {
                            if (!Character.isDigit(i) && i != '!') {
                                output += token + " ";
                                //if it is within a word, it doesn't count, so continue scanning the next tokens
                                continue tokenprocessor;
                            }
                        }
                        int newToken = Integer.valueOf(token.trim().replaceAll("[a-zA-Z]", "").replaceAll("!", ""));
                        //replace all letters with nothing
                        long newNum;
                        if (newToken <= 20) {
                            newNum = sub20Factorial(newToken);
                            output += addCommas(newNum + "") + " ";
                        } else {
                            output += addCommas(df.format(doubleFactorial(newToken))) + " ";
                        }
                    } else {
                        output += token + " ";
                    }
                } else {
                    output += token + " ";
                }
            }
            output += "\n";
        }
        return output.toString().trim();
    }

    public static String addCommas(String text) {
        DecimalFormat df = new DecimalFormat("#,###");
        if (!text.equals("∞")) {
            return df.format(Double.valueOf(text));
        }
        return text;
    }

    public static boolean containsFactorial(String text) {
        Scanner chop = new Scanner(text);
        boolean contains = false;
        while (chop.hasNext()) {
            String token = chop.next();
            if (token.charAt(token.length() - 1) == '!') {
                String nums = token.substring(0, token.length() - 2);
                boolean allInts = true;
                for (char i : nums.toCharArray()) {
                    allInts = allInts && Character.isDigit(i);
                }
                return allInts;
            } else {
                boolean allInts = true;
                for (char i : token.toCharArray()) {
                    allInts = allInts && Character.isDigit(i);
                }
                return allInts;
            }
        }

        return contains;
    }

    public static long sub20Factorial(String num) {
        if (num.charAt(num.length() - 1) == '!') { // remove exclamation mark if necessary
            num = num.substring(0, num.length() - 1);
        }
        return sub20Factorial(Integer.valueOf(num));
    }

    public static long sub20Factorial(int num) {
        long total = 1;
        for (int i = 2; i <= num; i++) {
            total *= i;
        }
        return total;
    }

    public static Double doubleFactorial(int num) {
        double result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
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
