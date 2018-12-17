package com.sinelnikov.competetive.week2;

import java.io.PrintWriter;
import java.util.Scanner;

public class CheapestPermutation {
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        n = in.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                a[i][j] = in.nextInt();

        int[] result = new int[n];

        solve(a, result);

        for (int i = 0; i < result.length; ++i) {
            if (i != 0) out.print(' ');
            out.print(result[i]);
        }
        out.println();

        in.close();
        out.close();
    }

    public static void heapPermutation(int[] a, int size, int[][] matrix, int[] currentMin, int[] minA) {
        if (size == 1) {

            // permutation found
            int sum = 0;
            for (int i = 0; i < a.length-1; i++) {
                // System.out.print(a[i] + " ");
                sum+=matrix[a[i]][a[i+1]];
            }
            // System.out.println(a[a.length - 1]);
            //  System.out.println("Sum: " + sum);
            if (currentMin[0] > sum) {
                currentMin[0] = sum;
                System.arraycopy(a, 0, minA, 0, a.length);
            }
            return;
        }
        for (int i = 0; i < size; i++) {
            heapPermutation(a, size-1, matrix, currentMin, minA);
            int buf = 0;
            if (size % 2 == 1) {
                buf = a[0];
                a[0] = a[size-1];
                a[size-1] = buf;
            } else {
                buf = a[i];
                a[i] = a[size-1];
                a[size-1] = buf;
            }
        }
    }

    public static void solve(int[][] a, int[] result) {
        int n = a.length;

        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = i;
        }
        heapPermutation(input, n, a, new int[] { Integer.MAX_VALUE }, result);
        // System.out.println("Result");
        for (int i = 0; i < n; i++) {
            result[i] ++;
            // System.out.print(result[i] + " ");
        }
        // System.out.println();
    }
}