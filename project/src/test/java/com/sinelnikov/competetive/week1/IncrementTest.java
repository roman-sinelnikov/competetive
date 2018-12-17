package com.sinelnikov.competetive.week1;

import org.junit.Assert;
import org.junit.Test;

public class IncrementTest {

    @Test
    public void testCase1() {
        Assert.assertEquals(1, Increment.getNextDigits("1"));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(2, Increment.getNextDigits("9"));
    }

    @Test
    public void testCase3() {
        Assert.assertEquals(20, Increment.getNextDigits("98234714857134561234"));
    }

    @Test
    public void testCase4() {
        Assert.assertEquals(6, Increment.getNextDigits("999989"));
    }

    @Test
    public void testCase5() {
        Assert.assertEquals(7, Increment.getNextDigits("999999"));
    }
}
