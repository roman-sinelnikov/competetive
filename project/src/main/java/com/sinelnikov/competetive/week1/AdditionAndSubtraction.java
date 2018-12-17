package com.sinelnikov.competetive.week1;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AdditionAndSubtraction {

    /*
        Given two integers x and y, construct an infinite sequence of integers A = {a0,a1,a2,...}
        as follows: a0 =0andforeveryi≥1,a2i−1 =a2i−2 +xanda2i =a2i−1 −y.
        Given three integers x, y and z, find the index of the first occurrence of z in A
        or report that z does not appear in A.
        Forexample,ifx=2,y=1andz=3,thenA=(0,2,1,3,2,4,3,...)andtheansweris3(a3 =3 and
        this is the first occurrence of 3 in A). If x = 2, y = 0 and z = 3, then A = (0,2,2,4,4,6,6,...)
        and the answer is −1 (there is no occurrence of 3 in A).
     */
    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int x, y, z;
        x = in.nextInt();
        y = in.nextInt();
        z = in.nextInt();

        int result = -1;

        result = exists(x, y, z);

        out.println(result);

        in.close();
        out.close();
    }

    public static int exists(int x, int y, int z) {
        if (z == 0) {
            return 0;
        }
        if (x == y) {
            if (x == z) return 1;
            else return -1;
        }

        int aprev = 0;

        for (int i = 1;;i++) {
            int a;
            if (i % 2 == 1) {
                a = aprev + x;
                if (x < y && a < z) { // x < y means function is increasing
                    return -1;
                }

            } else {
                a = aprev - y;
                if (x > y && a > z) { // x > y means function is decreasing
                    return -1;
                }
            }

            if (z == a) {
                return i;
            }


            aprev = a;
        }
    }
}