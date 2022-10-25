package org.algo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Prima {
    private final PriorityQueue<Edge> Rs;
    private final PriorityQueue<Edge> R;
    private final List<Edge> T = new ArrayList<>();
    private final Set<Integer> nodes = new HashSet<>();

    private final int numberNodes;

    public Prima(@NotNull GraphAsTuple graph) {
        Comparator<Edge> comparator = Comparator.comparingDouble(Edge::w);
        Rs = new PriorityQueue<>(comparator);
        R = new PriorityQueue<>(comparator);
        Rs.addAll(graph.getEdges());
        numberNodes = graph.getV();
    }


    private @Nullable Edge getMin(PriorityQueue<Edge> Rs, @NotNull Set<Integer> nodes) {
        for (Integer v : nodes) {
            for (Edge e : Rs) {
                if ( ( (e.u() == v) || (e.v() == v) ) && ( (!nodes.contains(e.u())) || (!nodes.contains(e.v())) ) ) {
                    R.add(e);
                }
            }
        }
        if (!R.isEmpty()) {
            Edge u = R.poll();
            R.clear();
            return u;
        }
        return null;
    }
    public void minOstTree() {
        Edge e_zero = Rs.poll();
        assert e_zero != null;
        nodes.add(e_zero.u());
        nodes.add(e_zero.v());
        T.add(e_zero);


        while (nodes.size() != numberNodes) {
            Edge u = getMin(Rs, nodes);
            if (u == null) {
                break;
            }
            T.add(u);
            nodes.add(u.u());
            nodes.add(u.v());

        }

    }

    public List<Edge> getT() {
        return T;
    }


    public static void main(String[] args) {
        GraphAsTuple graph = Graph.graphTuple();
        Prima prima = new Prima(graph);
        prima.minOstTree();
        System.out.println(prima.getT());

    }
}
