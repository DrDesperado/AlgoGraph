package org.algo;

import org.jetbrains.annotations.NotNull;

public class FloydWarshall {
    public static void main(String[] args) {

        GraphAsAdjacencyMatrix graph = Graph.adjMatrix();

        FloydWarshall.minMatrix(graph);

        graph.printAdj();


    }

    public static void minMatrix(@NotNull GraphAsAdjacencyMatrix graph) {

        for (int k = 0 ; k < graph.getN(); k++) {
            for (int i = 0 ; i < graph.getN(); i++) {
                for (int j = 0 ; j < graph.getN(); j++) {

                    if (graph.getAdj()[i][k] + graph.getAdj()[k][j] < graph.getAdj()[i][j]) {
                        graph.getAdj()[i][j] = graph.getAdj()[i][k] + graph.getAdj()[k][j];
                    }
                }
            }
        }
    }
}
