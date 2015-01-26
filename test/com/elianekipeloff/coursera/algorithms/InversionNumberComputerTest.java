package com.elianekipeloff.coursera.algorithms;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.net.URL;

import static org.junit.Assert.*;

public class InversionNumberComputerTest {

    @Test
    public void test6() throws Exception {
        String path = getSourcePath("test6.txt");
        InversionNumberComputer computer = new InversionNumberComputer(path, 6);
        long inversionsNumber = computer.getInversionsNumber();
        assertTrue(inversionsNumber == 3);
        for (int i = 0; i < computer.getArray().length; i++) {
            System.out.print(computer.getArray()[i] + " ");
        }
    }

    @Test
    public void testIntegerArray() throws Exception {
        String path = getSourcePath("IntegerArray.txt");
        InversionNumberComputer computer = new InversionNumberComputer(path, 100000);
        long inversionsNumber = computer.getInversionsNumber();
        assertTrue(inversionsNumber >0);
        System.out.println(inversionsNumber);
        for (int i = 0; i < computer.getArray().length; i++) {
            System.out.print(computer.getArray()[i] + " ");
        }
    }

    private String getSourcePath(String name) throws FileNotFoundException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(name);
        if (url == null){
            throw new FileNotFoundException("no file " + name + " in the source dir");
        }
        return url.getPath();
    }
}