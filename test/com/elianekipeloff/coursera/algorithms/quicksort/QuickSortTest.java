package com.elianekipeloff.coursera.algorithms.quicksort;

import com.elianekipeloff.coursera.algorithms.util.DataReader;
import org.junit.Before;
import org.junit.Test;


import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void test1() throws Exception {
        test("test1");
    }

    @Test
    public void test2() throws Exception {
        test("test2");
    }

    @Test
    public void test3() throws Exception {
        test("test3");
    }

    @Test
    public void test4() throws Exception {
        test("test4");
    }

    @Test
    public void test5() throws Exception {
        test("test5");
    }

    @Test
    public void test7() throws Exception {
        test("test7");
    }



    private void test(String name) throws FileNotFoundException {
        Integer[] toSort = readArray(name + ".txt");
        Integer[] sorted = readArray(name + "_sorted.txt");
        testLeft(sorted, toSort);
        testRight(sorted, toSort);
        testMedian(sorted, toSort);
    }


    private Integer[] readArray(String path) throws FileNotFoundException {
        return DataReader.readIntegerArray(DataReader.getSourcePath(path));
    }

    private void testLeft(Integer[] sorted, Integer[] toSort) {
        QuickSort<Integer> qs = new QuickSort<>(QuickSort.PivotTypes.LEFT, toSort);
        //assertArrayEquals(qs.sort(), sorted);
        qs.sort();
        //qs.printArray();
        System.out.println("left: " + qs.getComparisonsQuantity());
    }

    private void testRight(Integer[] sorted, Integer[] toSort) {
        QuickSort<Integer> qs = new QuickSort<>(QuickSort.PivotTypes.RIGHT, toSort);
        //assertArrayEquals(qs.sort(), sorted);
        qs.sort();
        //qs.printArray();
        System.out.println("right: " + qs.getComparisonsQuantity());
    }
    private void testMedian(Integer[] sorted, Integer[] toSort) {
        QuickSort<Integer> qs = new QuickSort<>(QuickSort.PivotTypes.MEDIAN, toSort);
        //(qs.sort(), sorted);
        qs.sort();
        //qs.printArray();
        System.out.println("median: " + qs.getComparisonsQuantity());
    }
}