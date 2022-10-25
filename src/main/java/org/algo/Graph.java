package org.algo;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graph {
    public static @NotNull GraphAsAdjacencyList adjGraph() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        GraphAsAdjacencyList graph = new GraphAsAdjacencyList();

        for (int i = -1; i < n; i++) {

            List<Integer> edges = new LinkedList<>();
            String str = scanner.nextLine();

            for (int j = 0 ; j < str.length(); j++) {

                int value = str.toCharArray()[j];

                if (value != 32) {
                    edges.add(value - 48);
                }

                graph.setGraph(i, edges);
            }
        }

        return graph;
    }

    public static @NotNull GraphAsAdjacencyMatrix adjMatrix() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        GraphAsAdjacencyMatrix graph = new GraphAsAdjacencyMatrix(n);

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                double value = scanner.nextDouble();
                graph.setMatrix(i, j, value);
            }
        }
        return graph;
    }

    public static @NotNull GraphAsTuple graphTuple(){

        Scanner scanner = new Scanner(System.in);
        int vert = scanner.nextInt();
        int e = scanner.nextInt();
        GraphAsTuple graph = new GraphAsTuple(vert);

        for (int i = 0 ; i < e ; i++) {

            int u = scanner.nextInt();
            int v = scanner.nextInt();
            double w = scanner.nextDouble();

            graph.addEdge(u,v,w);

        }

        return graph;
    }
}
