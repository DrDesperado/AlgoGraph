package org.algo;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    private static GraphAsAdjacencyList graph;
    private static List<Integer> grey;
    private static List<Integer> black;

    public static void main(String[] args) {
        graph = Graph.adjGraph();
        grey = new ArrayList<>();
        black = new ArrayList<>();
        search(0);
        System.out.println(grey);
        System.out.println(black);


    }

    public static void search(int edge) {
        grey.add(edge);

        List<Integer> nodes = graph.graph.get(edge);
        if (nodes != null) {
            for (Integer node : nodes) {
                if (!grey.contains(node)) {
                    search(node);
                }
            }
        }
        black.add(edge);
    }
}
