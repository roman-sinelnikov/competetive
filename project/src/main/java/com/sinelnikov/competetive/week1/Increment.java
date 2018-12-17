package com.sinelnikov.competetive.week1;

import java.io.PrintWriter;
import java.util.Scanner;

public class Increment {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String largeNumber = in.nextLine();
        out.println(getNextDigits(largeNumber));
        in.close();
        out.close();
    }

    public static int getNextDigits(String largeNumber) {
        for (int i = 0; i < largeNumber.length(); i++) {
            char ch = largeNumber.charAt(i);
            if (ch != '9') {
                return largeNumber.length();
            }
        }
        return largeNumber.length() + 1;
    }
}
