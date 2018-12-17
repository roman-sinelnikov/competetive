package com.sinelnikov.competetive.week1;

import org.junit.Assert;
import org.junit.Test;

public class AdditionAndSubstractionTest {

    @Test
    public void testCase1() {
        Assert.assertEquals(0, AdditionAndSubtraction.exists(0, 0, 0));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(3, AdditionAndSubtraction.exists(2, 1, 3));
    }

    @Test
    public void testCase3() {
        Assert.assertEquals(-1, AdditionAndSubtraction.exists(2, 0, 3));
    }

    @Test
    public void testCase4() {
        Assert.assertEquals(-1, AdditionAndSubtraction.exists(2, 3, 3));
    }

    @Test
    public void testCase5() {
        Assert.assertEquals(-1, AdditionAndSubtraction.exists(2, 2, 5));
    }
    @Test
    public void testCase6() {
        Assert.assertEquals(-1, AdditionAndSubtraction.exists(2, 2, 4));
    }

    @Test
    public void testCase7() {
        Assert.assertEquals(-1, AdditionAndSubtraction.exists(1, 1, 2));
    }

    @Test
    public void testCase8() {
        Assert.assertEquals(-1, AdditionAndSubtraction.exists(1, 1, 2));
    }
}
