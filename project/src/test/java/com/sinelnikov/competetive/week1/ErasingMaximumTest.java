package com.sinelnikov.competetive.week1;

import org.junit.Assert;
import org.junit.Test;

public class ErasingMaximumTest {

    @Test
    public void testCase1() {
        Assert.assertArrayEquals(new int[] { 1, 0, 2 }, ErasingMaximum.solve(new int[] { 1, 3, 2}));
    }

    @Test
    public void testCase2() {
        Assert.assertArrayEquals(new int[] { 4, 1, 4, 2, 0, 3, 4 }, ErasingMaximum.solve(new int[] { 4, 1, 4, 2, 4, 3, 4}));
    }

    @Test
    public void testCase3() {
        Assert.assertArrayEquals(new int[] { 4, 4, 0 }, ErasingMaximum.solve(new int[] { 4, 4, 4 }));
    }
}
