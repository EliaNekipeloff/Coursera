package com.elianekipeloff.coursera.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * @author Ella Nekipelova
 *         Date: 2/14/2015.
 */
public class Graph {
    private HashMap<Integer, List<Integer>> adjacencyMap;

    public Graph() {
        this.adjacencyMap = new HashMap<>();
    }

    public Graph(List<String> adjacencyList) {
        this.adjacencyMap = new HashMap<>();
        for (String str : adjacencyList) {
            String[] splitted = str.split("\\s");
            if (splitted.length > 1) {
                List<Integer> set = new ArrayList<>();
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

    public List<Integer> getAdjacentNodes(Integer node) {
        return adjacencyMap.get(node);
    }

    public void addNode(Integer node, List<Integer> adjacentNodes) {
        if (!adjacencyMap.containsKey(node)) {
            adjacencyMap.put(node, adjacentNodes);
        }
    }

    public Integer getNode(int index) {
        return (Integer) adjacencyMap.keySet().toArray()[index];
    }

    public void removeEdge(Integer first, Integer second) {
        List<Integer> firstSet = adjacencyMap.get(first);
        if (firstSet.size() == 0) {
            removeNode(first);
        } else {
            firstSet.remove(second);
        }
        List<Integer> secondSet = adjacencyMap.get(second);
        if (secondSet.size() == 0) {
            removeNode(second);
        } else {
            secondSet.remove(first);
        }
    }

    public void merge(Integer first, Integer second) {
        List<Integer> secondSet = adjacencyMap.get(second);
        List<Integer> firstSet = adjacencyMap.get(first);
        int firstSize = firstSet.size();
        int secondSize = secondSet.size();
        if (firstSize > secondSize) {
            copy(second, secondSet, first, firstSet);
        } else {
            copy(first, firstSet, second, secondSet);
        }
    }

    private void copy(Integer fromNode, List<Integer> fromList, Integer toNode, List<Integer> toList) {
        Iterator<Integer> fromListIterator = fromList.iterator();
        while (fromListIterator.hasNext()) {
            if (fromListIterator.next().equals(toNode)) {
                fromListIterator.remove();
            }
        }

        Iterator<Integer> toListIterator = toList.iterator();
        while (toListIterator.hasNext()) {
            if (toListIterator.next().equals(fromNode)) {
                toListIterator.remove();
            }
        }
        toList.addAll(fromList);
        for (Integer fromAdjacent : fromList) {
            List<Integer> fromAdjacentList = adjacencyMap.get(fromAdjacent);
            fromAdjacentList.add(toNode);
            Iterator<Integer> fromAdjacentListIterator = fromAdjacentList.iterator();
            while (fromAdjacentListIterator.hasNext()) {
                if (fromAdjacentListIterator.next().equals(fromNode)) {
                    fromAdjacentListIterator.remove();
                }
            }
        }
        removeNode(fromNode);

    }

    public void removeNode(Integer node) {
        adjacencyMap.remove(node);
    }

}
