package org.algo;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class FordBellman {
    protected final double[] distance;

    protected FordBellman(int n, int source) {
        distance = new double[n];
        Arrays.fill(distance, Double.POSITIVE_INFINITY);
        distance[source] = 0;
    }

    public double[] minDistance(@NotNull GraphAsTuple graph) {

        for (int i = 0 ; i < graph.getV() - 1 ; i++) {
            for (Edge e : graph.getEdges()) {
                int u = e.u(), v = e.v();
                double w = e.w();

                if (distance[v] > distance[u] + w) {
                    distance[v] = distance[u] + w;
                }
            }
        }
        return distance;
    }



    public static void main(String[] args) {
        GraphAsTuple graph = Graph.graphTuple();

        Scanner scanner = new Scanner(System.in);
        int source = scanner.nextInt();

        FordBellman dist = new FordBellman(graph.getV(), source);

        System.out.println(Arrays.toString(dist.minDistance(graph)));
    }
}
