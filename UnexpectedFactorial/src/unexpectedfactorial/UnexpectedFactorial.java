package unexpectedfactorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Tim Barber
 */
public class UnexpectedFactorial {

    public static void main(String[] args) throws IOException {
        System.out.println("Copyright 2018 Tim Barber"); //Header

        Scanner keyboard = new Scanner(System.in);
        Scanner file;
        try {
            file = new Scanner(new File("Text.txt"));
        } catch (FileNotFoundException e) {
            FileWriter creater = new FileWriter(new File("Text.txt"));
            PrintWriter printer = new PrintWriter("Text.txt", "UTF-8");
            printer.print("Put your text in here!");
            printer.close();
            creater.close();
            file = new Scanner("");
        }

        FileWriter writer = new FileWriter(new File("output.txt"));
        PrintWriter print_line = new PrintWriter("output.txt", "UTF-8");

        if (file.hasNext()) {
            String solved = FactorialFinder.solve(file.useDelimiter("\\Z").next());
            /*
             * I found this ingenious way to set a string to a file with a
             * scanner by setting the token delimiter to \Z, which is the end of
             * a string anchor (whatever that means). Setting the delimeter to
             * this effectively makes the entire file one big token, which you
             * can then access with .next() method.
             * source: "https://stackoverflow.com/a/3403112/8079326"
             */
            System.out.println(solved);
            print_line.print(solved + "");
        } else {
            System.out.print("Enter your text: ");
            String text = keyboard.nextLine();
            String solved = FactorialFinder.solve(text);
            System.out.println(solved);
            print_line.print(solved);
        }
        print_line.close();

    }
}

/*
 * The MIT License
 *
 * Copyright 2018 Tim Barber.
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
