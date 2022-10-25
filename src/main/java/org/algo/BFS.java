package org.algo;


import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        @NotNull GraphAsAdjacencyList graph = Graph.adjGraph();

        List<Integer> visited = new ArrayList<>();
        visited.add(0);

        Queue<Integer> queList = new LinkedList<>(graph.graph.get(0));

        while (!queList.isEmpty()) {
            int key = queList.peek();
            if (!visited.contains(key)) {
                queList.addAll(graph.graph.get(key));
                visited.add(key);
            }
            queList.poll();
        }
        System.out.println(visited);
    }
}

