package com.elianekipeloff.coursera.algorithms.graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author Ella Nekipelova
 *         Date: 2/14/2015.
 */
public class MinCutAlgorithm {
    private Graph graph;
    private final long ATTEMPTS;

    public MinCutAlgorithm(String path) throws IOException {
        List<String> adjacencyList = readData(path);
        graph = new Graph(adjacencyList);
        ATTEMPTS = adjacencyList.size() ^ 2;

    }

    public void getMinCut() {
        while (graph.getSize() > 0) {
            contract();
        }
    }

    public int getGraphSize() {
        return graph.getSize();
    }

    private List<String> readData(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    private void contract() {
        Integer first = getRandomNode();
        if (graph.getAdjacentNodes(first).size() == 0) {
            graph.removeNode(first);
        } else {
            Integer second = getRandomEdge(first);
            graph.removeEdge(first, second);
        }
    }

    private Integer getRandomNode() {
        int index = new Random().nextInt(graph.getSize());
        return graph.getNode(index);
    }

    private Integer getRandomEdge(Integer node) {
        Set<Integer> adjacent = graph.getAdjacentNodes(node);

        int index = new Random().nextInt(adjacent.size());
        return (Integer) adjacent.toArray()[index];
    }

}
