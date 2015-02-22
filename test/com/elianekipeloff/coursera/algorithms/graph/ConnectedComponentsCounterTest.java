package com.elianekipeloff.coursera.algorithms.graph;

import com.elianekipeloff.coursera.algorithms.graph.search.ConnectedComponentsCounter;
import com.elianekipeloff.coursera.algorithms.util.DataReader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectedComponentsCounterTest {

    private ConnectedComponentsCounter counter;
    @Before
    public void setUp() throws Exception {    }

    @Test
    public void testSCC1() throws Exception {
        String path = DataReader.getSourcePath("scc1.txt");
        counter = new ConnectedComponentsCounter(path, 9);
        assertArrayEquals(new Integer[] {3,3,3,0,0}, counter.getLargestConnectedComponents(5));
    }

    @Test
    public void testSCC2() throws Exception {
        String path = DataReader.getSourcePath("scc2.txt");
        counter = new ConnectedComponentsCounter(path, 8);
        assertArrayEquals(new Integer[] {3,3,2,0,0}, counter.getLargestConnectedComponents(5));
    }

    @Test
    public void testSCC3() throws Exception {
        String path = DataReader.getSourcePath("scc3.txt");
        counter = new ConnectedComponentsCounter(path, 8);
        assertArrayEquals(new Integer[] {7,1,0,0,0}, counter.getLargestConnectedComponents(5));
    }

    @Test
    public void testSCC() throws Exception {
        String path = DataReader.getSourcePath("SCC.txt");
        counter = new ConnectedComponentsCounter(path, 875714);
        for (int i : counter.getLargestConnectedComponents(5)) {
            System.out.print(i + ",");
        }
    }
}