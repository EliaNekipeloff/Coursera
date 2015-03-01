package com.elianekipeloff.coursera.algorithms.graph.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.elianekipeloff.coursera.algorithms.graph.dijkstra.Graph.Node;

/**
 * @author Ella Nekipelova
 *         Date: 3/1/2015.
 */
public class ShortestPathFinder {
    private Graph graph;
    private int graphSize;

    public ShortestPathFinder(String path, int graphSize) throws Exception {
        graph = new Graph(path, graphSize);
        this.graphSize = graphSize;
    }

    public void findShortestPaths() {
        int i = 1;
        while (i < graphSize + 1) {
            Node root = graph.extractMin();
            for (Integer id : root.getAdjacentList().keySet()) {
                Node node = graph.getNode(id);
                int newGreedyScore = root.getGreedyScore() + root.getAdjacentList().get(id);
                if (node.getGreedyScore() > newGreedyScore) {
                    node.setGreedyScore(newGreedyScore);
                    graph.getNodeHeap().heapify();
                }
                if (!node.isVisited()) {
                    graph.getNodeHeap().insert(node);
                    node.setVisited(true);
                }
            }
            i++;
        }
    }

    public void exhaustiveFindShortestPaths() {
        Node root = graph.getNode(1);
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node n = nodes.remove(0);
            n.setVisited(true);
            Map<Integer, Integer> adj = n.getAdjacentList();
            for (int i : adj.keySet()) {
                Node t = graph.getNode(i);
                if (t.isVisited()) {
                    continue;
                }
                int dist = n.getGreedyScore() + adj.get(i);
                if (t.getGreedyScore() > dist) {
                    t.setGreedyScore(dist);
                    nodes.remove(t);
                    int j = 0;
                    while ((j < nodes.size()) && (nodes.get(j).getGreedyScore() < dist)) {
                        j++;
                    }
                    if (j >= nodes.size()) {
                        nodes.add(t);
                    } else {
                        nodes.add(j, t);
                    }
                }
            }
        }
    }

    public Graph getGraph() {
        return graph;
    }
}
