package com.elianekipeloff.coursera.algorithms.graph;

import com.elianekipeloff.coursera.algorithms.graph.mincut.Graph;
import com.elianekipeloff.coursera.algorithms.util.DataReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GraphTest {
    private Graph graph;
    private List<String> adjacencyList;

    @Before
    public void setUp() throws IOException{
        String path = DataReader.getSourcePath("smallGraph.txt");
        adjacencyList = Files.readAllLines(Paths.get(path));
        graph = new Graph(adjacencyList);
    }


    @Test
    public void testGraphCreation() throws IOException {
        setUp();
        assertEquals(adjacencyList.size(), graph.getSize());
    }

    @Test
    public void testMerge() throws IOException {
        setUp();
        Integer first = Integer.valueOf(adjacencyList.get(0).split("\\s")[0]);
        Integer second = Integer.valueOf(adjacencyList.get(1).split("\\s")[0]);
        graph.merge(first, second);
        assertEquals(adjacencyList.size()-1, graph.getSize());
    }
    @Test
    public void testRemoveEdge() throws IOException {
        setUp();
        Integer first = Integer.valueOf(adjacencyList.get(0).split("\\s")[0]);
        Integer second = Integer.valueOf(adjacencyList.get(36).split("\\s")[0]);
        List<Integer> firstSet = graph.getAdjacentNodes(first);
        int firstSizeBefore = firstSet.size();
        firstSet.stream().forEach((a) ->System.out.print(a + " "));
        System.out.println();
        List<Integer> secondSet = graph.getAdjacentNodes(second);
        int secondSizeBefore = secondSet.size();
        System.out.println();
        secondSet.stream().forEach((a) ->System.out.print(a + " "));
        graph.removeEdge(first, second);
        System.out.println();
        firstSet.stream().forEach((a) ->System.out.print(a + " "));
        System.out.println();
        secondSet.stream().forEach((a) ->System.out.print(a + " "));
        assertEquals(firstSizeBefore - 1, firstSet.size());
        assertEquals(secondSizeBefore - 1, secondSet.size());
    }

    @Test
    public void testRemoveAllEdges() throws IOException {
        setUp();
        int graphSize = graph.getSize();
        Integer first = Integer.valueOf(adjacencyList.get(0).split("\\s")[0]);
        List<Integer> set = new ArrayList<>();
        graph.getAdjacentNodes(first).forEach(set::add);
        for (Integer adj : set) {
            graph.removeEdge(first, adj);
        }
        assertEquals(0, graph.getAdjacentNodes(first).size());
        graph.removeEdge(first, 12);
        assertNull(graph.getAdjacentNodes(first));
        assertEquals(graphSize-1, graph.getSize());
    }

}