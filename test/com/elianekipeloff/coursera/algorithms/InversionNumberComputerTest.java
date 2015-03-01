package com.elianekipeloff.coursera.algorithms;

import org.junit.Test;


import static com.elianekipeloff.coursera.algorithms.util.DataReader.getSourcePath;
import static org.junit.Assert.*;

public class InversionNumberComputerTest {

    @Test
    public void test6() throws Exception {
        String path = getSourcePath("test5.txt");
        InversionNumberComputer computer = new InversionNumberComputer(path);
        long inversionsNumber = computer.getInversionsNumber();
        assertTrue(inversionsNumber == 3);
        for (int i = 0; i < computer.getArray().length; i++) {
            System.out.print(computer.getArray()[i] + " ");
        }
    }

    @Test
    public void testIntegerArray() throws Exception {
        String path = getSourcePath("test7.txt");
        InversionNumberComputer computer = new InversionNumberComputer(path);
        long inversionsNumber = computer.getInversionsNumber();
        assertTrue(inversionsNumber >0);
        System.out.println(inversionsNumber);
        for (int i = 0; i < computer.getArray().length; i++) {
            System.out.print(computer.getArray()[i] + " ");
        }
    }



}