package org.algo;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dijkstra extends FordBellman{

    private final List<Integer> visited;

    protected Dijkstra(int n, int source) {
        super(n, source);
        visited = new ArrayList<>();
    }

    public double[] minDistance(@NotNull GraphAsTuple graph, int source) {
        double minValue = Double.POSITIVE_INFINITY;
        int next = 1;
        while (visited.size() != graph.getV()) {
            visited.add(source);
            for (Edge e : graph.getEdges()) {
                int u = e.u(), v = e.v();
                double w = e.w();
                if ((distance[v] > distance[u] + w) && (!visited.contains(v))){
                    distance[v] = distance[u] + w;

                    if (minValue > distance[v]) {
                        minValue = distance[v];
                        next = v;
                    }
                }
            }
            source = next;
        }
        return  distance;
    }

    public static void main(String[] args) {
        GraphAsTuple graph = Graph.graphTuple();

        Scanner scanner = new Scanner(System.in);
        int source = scanner.nextInt();

        Dijkstra dist = new Dijkstra(graph.getV(), source);

        System.out.println(Arrays.toString(dist.minDistance(graph, source)));

    }
}


