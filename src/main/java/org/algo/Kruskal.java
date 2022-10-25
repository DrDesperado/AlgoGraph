package org.algo;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Kruskal {
    private final PriorityQueue<Edge> Rs;
    private final Map<Integer, HashSet<Integer>> D = new HashMap<>();
    private final List<Edge> T = new ArrayList<>();

    private int items;

    public Kruskal(@NotNull GraphAsTuple graph) {

        Comparator<Edge> comparator = Comparator.comparingDouble(Edge::w);
        Rs = new PriorityQueue<>(comparator);
        Rs.addAll(graph.getEdges());

        for (int i = 0 ; i < graph.getV() ; i++) {
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            D.put(i, set);
        }

        items = graph.getV();
    }


    public List<Edge> minOstTree() {
        while (items != 1) {

            Edge e = Rs.poll();
            assert e != null;

            if (D.get(e.v()) != D.get(e.u())) {

                T.add(e);

                for (int i : D.get(e.v())) {
                    D.get(e.u()).add(i);
                    D.put(i, D.get(e.u()));
                }

                D.put(e.v(), D.get(e.u()));

                items--;
            }
        }
        return T;
    }

    public static void main(String[] args) {

        GraphAsTuple graph = Graph.graphTuple();
        Kruskal kruskal = new Kruskal(graph);

        System.out.println(Arrays.toString(kruskal.minOstTree().toArray()));

    }
}
