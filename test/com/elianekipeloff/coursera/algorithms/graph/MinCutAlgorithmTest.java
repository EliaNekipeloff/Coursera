package com.elianekipeloff.coursera.algorithms.graph;

import com.elianekipeloff.coursera.algorithms.util.DataReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class MinCutAlgorithmTest {

    private MinCutAlgorithm algorithm;

    @Before
    public void setUp() {
        try {
            algorithm = new MinCutAlgorithm(DataReader.getSourcePath("graph.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test() throws Exception {
        setUp();
        System.out.println(algorithm.getMinCut());
        //assertEquals(3, algorithm.getMinCut());
    }

}