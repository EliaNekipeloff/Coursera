package com.elianekipeloff.coursera.algorithms.graph.dijkstra;

import static org.junit.Assert.*;

import com.elianekipeloff.coursera.algorithms.util.DataReader;
import org.junit.Test;

public class ShortestPathFinderTest {

    @Test
    public void testShortestPath1() throws Exception {
        ShortestPathFinder finder = new ShortestPathFinder(DataReader.getSourcePath("graph1.txt"), 5);
        finder.exhaustiveFindShortestPaths();
        for (int i = 1; i <= 5; i++) {
            System.out.print(finder.getGraph().getNode(i).getGreedyScore() + ",");

        }
    }

    @Test
    public void testShortestPath2() throws Exception {
        ShortestPathFinder finder = new ShortestPathFinder(DataReader.getSourcePath("graph2.txt"), 5);
        finder.exhaustiveFindShortestPaths();
        for (int i = 1; i <= 5; i++) {
            System.out.print(finder.getGraph().getNode(i).getGreedyScore() + ",");

        }
    }

    @Test
    public void testShortestPath3() throws Exception {
        ShortestPathFinder finder = new ShortestPathFinder(DataReader.getSourcePath("graph3.txt"), 9);
        finder.exhaustiveFindShortestPaths();
        int[] correct = new int[] {0, 4,12,19,21,11,9,8,14};
        for (int i = 0; i < correct.length; i++) {
            assertEquals(correct[i], finder.getGraph().getNode(i +1).getGreedyScore());
        }

    }

    @Test
    public void testShortestPath4() throws Exception {
        ShortestPathFinder finder = new ShortestPathFinder(DataReader.getSourcePath("graph4.txt"), 10);
        finder.exhaustiveFindShortestPaths();
        assertEquals(0, finder.getGraph().getNode(1).getGreedyScore());
        assertEquals(3, finder.getGraph().getNode(2).getGreedyScore());
        assertEquals(4, finder.getGraph().getNode(3).getGreedyScore());
        assertEquals(3, finder.getGraph().getNode(4).getGreedyScore());
        assertEquals(2, finder.getGraph().getNode(5).getGreedyScore());
        assertEquals(4, finder.getGraph().getNode(6).getGreedyScore());
        assertEquals(1, finder.getGraph().getNode(7).getGreedyScore());
        assertEquals(11, finder.getGraph().getNode(8).getGreedyScore());
        assertEquals(5, finder.getGraph().getNode(9).getGreedyScore());
        assertEquals(1000000, finder.getGraph().getNode(10).getGreedyScore());

    }

    @Test
    public void testShortestPath60() throws Exception {
        ShortestPathFinder finder = new ShortestPathFinder(DataReader.getSourcePath("graph60.txt"), 25);
        finder.exhaustiveFindShortestPaths();
        int[] indexes = new int[]{3, 7, 10, 13, 17, 23, 25};
        int[] correct = new int[]{46, 35, 34, 41, 67, 19, 45};
        for (int i = 0; i < indexes.length; i++) {
            assertEquals(correct[i], finder.getGraph().getNode(indexes[i]).getGreedyScore());
        }

    }

    @Test
    public void testShortestPath() throws Exception {
        ShortestPathFinder finder = new ShortestPathFinder(DataReader.getSourcePath("graph200.txt"), 200);
        finder.findShortestPaths();
        int[] indexes = new int[]{10,30,50,80,90,110,130,160,180,190};
        int[] correct = new int[]{3205,2303,3152,982,2018,2317,1820,2403,3027,2596};
        for (int i = 0; i < indexes.length; i++) {
            System.out.println(finder.getGraph().getNode(indexes[i]).getId() + " " + finder.getGraph().getNode(indexes[i]).getGreedyScore());
            assertEquals(correct[i], finder.getGraph().getNode(indexes[i]).getGreedyScore());
        }
    }

    @Test
    public void testShortestPathFinal() throws Exception {
        ShortestPathFinder finder = new ShortestPathFinder(DataReader.getSourcePath("graph200.txt"), 200);
        finder.findShortestPaths();
        int[] indexes = new int[]{7,37,59,82,99,115,133,165,188,197};
        for (int index : indexes) {
            System.out.print(finder.getGraph().getNode(index).getGreedyScore() + ",");

        }
    }

}