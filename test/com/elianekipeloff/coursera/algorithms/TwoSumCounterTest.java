package com.elianekipeloff.coursera.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumCounterTest {

    @Test
    public void test1() throws Exception {
        TwoSumCounter counter = new TwoSumCounter("array1.txt");
        assertEquals(17, counter.countAll());
    }

    @Test
    public void test10ElsWithHashSet() throws Exception {
        TwoSumCounter counter = new TwoSumCounter("array2.txt");
        assertEquals(5, counter.count(10));
    }

    @Test
    public void test10ElsWithSort() throws Exception {
        TwoSumCounter counter = new TwoSumCounter("array2.txt");
        assertEquals(5, counter.countWithSort(10));
    }

    @Test
    public void testRepeatedElsWithHashSet() throws Exception {
        TwoSumCounter counter = new TwoSumCounter("array3.txt");
        assertEquals(5, counter.count(10));
    }

    @Test
    public void testRepeatedElsWithSort() throws Exception {
        TwoSumCounter counter = new TwoSumCounter("array3.txt");
        assertEquals(5, counter.countWithSort(10));
    }
}