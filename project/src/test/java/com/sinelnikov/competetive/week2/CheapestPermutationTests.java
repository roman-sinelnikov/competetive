package com.sinelnikov.competetive.week2;

import com.sinelnikov.competetive.week1.StraightFlush;
import org.junit.Assert;
import org.junit.Test;

public class CheapestPermutationTests {

    @Test
    public void testCase1() {

        int[][] a = new int[][] {
                new int[] { 0, 1, 2 },
                new int[] { 1, 0, 4 },
                new int[] { 2, 4, 0 }
        };
        int[] result = new int[3];
        CheapestPermutation.solve(a, result);
        Assert.assertArrayEquals(new int[] { 2, 1, 3 }, result);
    }

    @Test
    public void testCase2() {
        int[][] a = new int[][] {
                new int[] { 0, 1, 1, 1 },
                new int[] { 1, 0, 1, 1 },
                new int[] { 1, 1, 0, 1 },
                new int[] { 1, 1, 1, 0 }
        };
        int[] result = new int[4];
        CheapestPermutation.solve(a, result);
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4 }, result);
    }

    @Test
    public void testCase3() {
    }

    @Test
    public void testCase4() {
    }

    @Test
    public void testCase5() {
    }

    @Test
    public void testCase6() {
    }
}
