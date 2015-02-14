package com.elianekipeloff.coursera.algorithms.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ella Nekipelova
 *         Date: 2/14/2015.
 */
public class Graph {
    private HashMap<Integer, Set<Integer>> adjacencyMap;

    public Graph() {
        this.adjacencyMap = new HashMap<>();
    }

    public Graph(List<String> adjacencyList) {
        this.adjacencyMap = new HashMap<>();
        for (String str : adjacencyList) {
            String[] splitted = str.split("\\s");
            if (splitted.length > 1) {
                Set<Integer> set = new HashSet<>();
                for (int i = 1; i < splitted.length; i++) {
                    set.add(Integer.valueOf(splitted[i]));
                }
                adjacencyMap.put(Integer.valueOf(splitted[0]), set);
            }
        }
    }

    public int getSize() {
        return adjacencyMap.size();
    }

    public Set<Integer> getAdjacentNodes(Integer node) {
        return adjacencyMap.get(node);
    }
    public void addNode(Integer node, Set<Integer> adjacentNodes) {
        if (!adjacencyMap.containsKey(node)) {
            adjacencyMap.put(node, adjacentNodes);
        }
    }

    public Integer getNode(int index) {
        return (Integer)adjacencyMap.keySet().toArray()[index];
    }

    public void removeEdge(Integer first, Integer second) {
        Set<Integer> firstSet = adjacencyMap.get(first);
        if (firstSet.size() == 0) {
            removeNode(first);
        } else {
            firstSet.remove(second);
        }
        Set<Integer> secondSet = adjacencyMap.get(second);
        if (secondSet.size() == 0) {
            removeNode(second);
        } else {
            secondSet.remove(first);
        }
    }

    public void removeNode(Integer node) {
        adjacencyMap.remove(node);
    }

}
