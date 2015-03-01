package com.elianekipeloff.coursera.algorithms.graph.dijkstra;

import datastruct.Heap;
import datastruct.MinHeap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;


/**
 * @author Ella Nekipelova
 *         Date: 3/1/2015.
 */
public class Graph {
    private Heap<Node> nodeHeap;
    private Node[] nodes;
    private final int graphSize;

    public Graph(String path, int graphSize) throws Exception {
        this.graphSize = graphSize + 1;
        nodes = new Node[this.graphSize];
        this.nodeHeap = new MinHeap<Node>(this.graphSize) {
            @Override
            protected Node[] createElements(int length) {
                return new Node[length];
            }

            @Override
            protected Node toEl(String str) {
                return null;
            }
        };
        for (int i = 0; i < this.graphSize; i++) {
            nodes[i] = new Node(i);
        }
        readData(path);
        nodes[1].setGreedyScore(0);
        nodeHeap.insert(nodes[1]);

    }

    private void readData(String path) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        while (reader.ready()) {
            String[] splitted = reader.readLine().split("\\s");
            Node fromNode = nodes[Integer.valueOf(splitted[0])];

            for (int i = 1; i < splitted.length; i++) {
                String[] adjacentNodeData = splitted[i].split(",");
                int length = Integer.decode(adjacentNodeData[1]);
                fromNode.getAdjacentList().put(Integer.decode(adjacentNodeData[0]), length);
                Node toNode = nodes[Integer.decode(adjacentNodeData[0])];
                toNode.getAdjacentList().put(fromNode.getId(), length);

            }

        }
    }

    public Node getNode(int index) {
        return nodes[index];
    }

    public Heap<Node> getNodeHeap() {
        return nodeHeap;
    }

    public int getGraphSize() {
        return graphSize;
    }

    public Node extractMin() {
        return nodeHeap.extract();
    }

    public static class Node implements Comparable<Node> {
        private final int id;
        private int greedyScore;
        private Map<Integer, Integer> adjacentList;
        private boolean isVisited;

        public Node(int id) {
            this.id = id;
            greedyScore = 1000000;
            isVisited = false;
            this.adjacentList = new HashMap<>();
        }


        public void setGreedyScore(int greedyScore) {
            this.greedyScore = greedyScore;
        }

        public int getId() {
            return id;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean isVisited) {
            this.isVisited = isVisited;
        }

        public int getGreedyScore() {
            return greedyScore;
        }

        public Map<Integer, Integer> getAdjacentList() {
            return adjacentList;
        }

        public void setAdjacentList(Map<Integer, Integer> adjacentList) {
            this.adjacentList = adjacentList;
        }

        @Override
        public int compareTo(Node o) {
            if (greedyScore < o.greedyScore) return -1;
            else if (greedyScore > o.greedyScore) return 1;
            else return 0;
        }
    }
}
