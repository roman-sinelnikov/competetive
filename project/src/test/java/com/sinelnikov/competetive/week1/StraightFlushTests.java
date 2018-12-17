package com.sinelnikov.competetive.week1;

import org.junit.Assert;
import org.junit.Test;

public class StraightFlushTests {

    @Test
    public void testCase1() {
        Assert.assertTrue(StraightFlush.isStraightFlush(new String[] { "2D", "5D", "3D", "4D", "6D"}));
    }

    @Test
    public void testCase2() {
        Assert.assertFalse(StraightFlush.isStraightFlush(new String[] { "AD", "KH", "QH", "JS", "TC"}));
    }

    @Test
    public void testCase3() {
        Assert.assertFalse(StraightFlush.isStraightFlush(new String[] { "AD" }));
    }

    @Test
    public void testCase4() {
        Assert.assertFalse(StraightFlush.isStraightFlush(new String[] { "GG" }));
    }

    @Test
    public void testCase5() {
        Assert.assertTrue(StraightFlush.isStraightFlush(new String[] { "2D", "5D", "3D", "4D", "AD"}));
    }

    @Test
    public void testCase6() {
        Assert.assertTrue(StraightFlush.isStraightFlush(new String[] { "AS", "KS", "QS", "JS", "TS"}));
    }
}
