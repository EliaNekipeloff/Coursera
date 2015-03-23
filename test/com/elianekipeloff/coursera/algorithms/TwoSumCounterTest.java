package com.elianekipeloff.coursera.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumCounterTest {

    @Test
    public void test1() throws Exception {
        TwoSumCounter counter = new TwoSumCounter("array1.txt");
        assertEquals(54, counter.countAll());
    }
}