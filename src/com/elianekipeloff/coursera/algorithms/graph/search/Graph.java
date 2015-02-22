package com.elianekipeloff.coursera.algorithms.graph.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ella Nekipelova
 *         Date: 2/22/2015.
 */
public class Graph {
    private final Node[] nodes;
    private final Set<Arc> arcs;

    private final int graphSize;

    public Graph(String path, int graphSize) throws Exception {
        this.graphSize = graphSize + 1;
        this.nodes = new Node[this.graphSize];
        this.arcs = new HashSet<>();
        readData(path);
    }

    public Node[] getNodes() {
        return nodes;
    }

    public Node[] getReversedNodes() {
        Node[] reversedNodes = new Node[graphSize];
        for (int i = 0; i < graphSize; i++) {
            reversedNodes[i] = new Node(i);
        }
        for (Arc arc : arcs) {
            reversedNodes[arc.getToId()].getTails().add(reversedNodes[arc.getFromId()]);
        }
        return reversedNodes;
    }


    private void readData(String path) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        for (int i = 0; i < graphSize; i++) {
            nodes[i] = new Node(i);
        }
        while (reader.ready()) {
            String[] splitted = reader.readLine().split("\\s");
            Node newFrom = nodes[Integer.valueOf(splitted[0])];
            Node newTo = nodes[Integer.valueOf(splitted[1])];
            arcs.add(new Arc(newFrom.getId(), newTo.getId()));
            newFrom.getTails().add(newTo);
        }
    }


    public static class Node implements Comparable {
        private boolean isVisited;
        private final int id;
        private Set<Node> tails;
        private long finishingTime;


        public Node(int id) {
            this.id = id;
            isVisited = false;
            this.tails = new HashSet<>();
            finishingTime = 0;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean isVisited) {
            this.isVisited = isVisited;
        }

        public int getId() {
            return id;
        }

        public Set<Node> getTails() {
            return tails;
        }


        public void setFinishingTime(long finishingTime) {
            this.finishingTime = finishingTime;
        }

        public void setTails(Set<Node> tails) {
            this.tails = tails;
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Node)) {
                throw new RuntimeException("Wrong data type");
            }
            Node that = (Node) o;
            if (that.finishingTime < this.finishingTime) return -1;
            else if (that.finishingTime > this.finishingTime) return 1;
            else return 0;
        }

        @Override
        public int hashCode() {
            return getId() * 31;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node)) {
                throw new RuntimeException("Wrong data type");
            }
            Node that = (Node) obj;
            return that.getId() == ((Node) obj).getId();
        }
    }

    private class Arc {
        private int fromId;
        private int toId;

        public Arc(int fromId, int toId) {
            this.fromId = fromId;
            this.toId = toId;
        }

        public int getFromId() {
            return fromId;
        }

        public int getToId() {
            return toId;
        }
    }
}
