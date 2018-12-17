package com.sinelnikov.competetive.week1;

import java.io.PrintWriter;
import java.util.Scanner;

public class ErasingMaximum {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        solve(a);

        for (int i = 0; i < a.length; ++i) {
            if (a[i] != 0) {
                if (i != 0) out.print(' ');
                out.print(a[i]);
            }
        }
        out.println();

        in.close();
        out.close();
    }

    public static int[] solve(int[] result) {
        int max = result[0];
        int maxCount = 1;
        int lastMaxIndex = 0;
        for (int i = 1; i < result.length; i++) {
            if (max < result[i]) {
                max = result[i];
                maxCount = 1;
                lastMaxIndex = i;
            } else if (max == result[i]) {
                maxCount += 1;
                if (maxCount == 3) {
                    lastMaxIndex = i;
                }
            }
        }
        result[lastMaxIndex] = 0;
        return result;
    }
}