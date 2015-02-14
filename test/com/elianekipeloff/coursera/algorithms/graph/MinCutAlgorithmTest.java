package com.elianekipeloff.coursera.algorithms.graph;

import com.elianekipeloff.coursera.algorithms.util.DataReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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
    public void test() {
        setUp();
        algorithm.getMinCut();
        System.out.println(algorithm.getGraphSize());
    }

}