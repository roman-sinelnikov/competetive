package com.sinelnikov.competetive.week2;

import org.junit.Assert;
import org.junit.Test;

public class KingTests {
    @Test
    public void testCase1() {
        Assert.assertEquals(1, King.solve(1, 2));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(8, King.solve(3, 3));
    }

    @Test
    public void testCase3() {
        Assert.assertEquals(133, King.solve(50, 3));
    }
}
