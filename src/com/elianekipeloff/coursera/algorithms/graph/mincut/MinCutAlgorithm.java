package com.elianekipeloff.coursera.algorithms.graph.mincut;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * @author Ella Nekipelova
 *         Date: 2/14/2015.
 */
public class MinCutAlgorithm {
    private Graph graph;
    private final long ATTEMPTS;
    private int minCutSize;
    private List<String> adjacencyList;

    public MinCutAlgorithm(String path) throws IOException {
        adjacencyList = readData(path);
        graph = new Graph(adjacencyList);
        ATTEMPTS = adjacencyList.size() * adjacencyList.size();
        minCutSize = adjacencyList.size()*2 -1;

    }

    public int getMinCut() throws Exception {
        int attemptNumber = 0;
        while (attemptNumber < ATTEMPTS) {
            clear();
            while (graph.getSize() > 2) {
                contract();
            }
            if (graph.getAdjacentNodes(graph.getNode(0)).size() != graph.getAdjacentNodes(graph.getNode(1)).size()) {
                throw new Exception("Algorithm error");
            }
            int currentMinCutSize = graph.getAdjacentNodes(graph.getNode(0)).size();
            if (minCutSize > currentMinCutSize) {
                minCutSize = currentMinCutSize;
            }
            System.out.println("Attempt #" + attemptNumber + ": " + currentMinCutSize);
            attemptNumber++;

        }
        return minCutSize;
    }

    private void clear() {
        graph = new Graph(adjacencyList);
    }

    public int getGraphSize() {
        return graph.getSize();
    }

    private List<String> readData(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    private void contract() {
        Integer first = getRandomNode();
        Integer second = getRandomEdge(first);
        graph.merge(first, second);
    }

    private Integer getRandomNode() {
        int index = new Random().nextInt(graph.getSize());
        return graph.getNode(index);
    }

    private Integer getRandomEdge(Integer node) {
        List<Integer> adjacent = graph.getAdjacentNodes(node);

        int index = new Random().nextInt(adjacent.size());
        return (Integer) adjacent.toArray()[index];
    }

}
