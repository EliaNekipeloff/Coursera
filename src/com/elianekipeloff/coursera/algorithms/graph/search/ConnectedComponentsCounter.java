package com.elianekipeloff.coursera.algorithms.graph.search;

import java.util.Arrays;
import java.util.Comparator;

import static com.elianekipeloff.coursera.algorithms.graph.search.Graph.Node;

/**
 * @author Ella Nekipelova
 *         Date: 2/22/2015.
 */
public class ConnectedComponentsCounter {
    private Graph graph;
    private int time;
    private final int graphSize;
    private Integer[] leaders;
    private int[] finishingTimes;

    public ConnectedComponentsCounter(String path, int graphSize) throws Exception {
        graph = new Graph(path, graphSize);
        this.graphSize = graphSize + 1;
        this.leaders = new Integer[this.graphSize];
        this.finishingTimes = new int[this.graphSize];
    }


    public Integer[] getLargestConnectedComponents(int number) {
        Node[] reversedNodes = graph.getReversedNodes();
        dfsForReversed(reversedNodes);
        Node[] nodes = graph.getNodes();
        for (int i = 1; i < graphSize; i++) {
            nodes[i].setFinishingTime(finishingTimes[i]);
        }
        Arrays.sort(nodes);
        dfsForNatural(nodes);
        Arrays.sort(leaders, Comparator.<Integer>reverseOrder());
        int i = 0;
        int count = 0;
        Integer[] result = new Integer[graphSize];
        int j = 0;
        while (i < graphSize) {
            while (j < leaders.length - 1 && leaders[j].equals(leaders[j + 1])) {
                count++;
                j++;
            }
            result[i] = count == 0 ? count : count + 1;
            i++;
            j++;
            count = 0;
        }

        Arrays.sort(result, Comparator.<Integer>reverseOrder());
        return Arrays.copyOf(result, number);
    }


    private void dfsForNatural(Node[] nodes) {
        for (int i = 0; i < graphSize; i++) {
            if (!nodes[i].isVisited()) {
                dfsLoop(nodes[i], nodes[i]);
            }
        }
    }

    private void dfsLoop(Node start, Node leader) {
        start.setVisited(true);
        leaders[start.getId()] = leader.getId();
        for (Node node : start.getTails()) {
            if (!node.isVisited()) {
                dfsLoop(node, leader);
            }
        }

    }

    private void dfsForReversed(Node[] nodes) {
        time = 0;
        for (int i = graphSize - 1; i > 0; i--) {
            if (!nodes[i].isVisited()) {
                dfsLoop(nodes[i]);
            }
        }
    }

    private void dfsLoop(Node start) {
        start.setVisited(true);
        start.getTails().stream().filter(tail -> !tail.isVisited()).forEach(this::dfsLoop);
        time++;
        finishingTimes[start.getId()] = time;
    }



}
