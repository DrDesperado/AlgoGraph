package org.algo;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GraphAsTuple extends ArrayList<Edge>{
    private final int v;
    private final List<Edge> edges;

    public GraphAsTuple(int v) {
        this.v = v;
        this.edges = new ArrayList<>();
    }

    public int getV() {
        return v;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(int u, int v, double w) {
        Edge e = new Edge(u,v,w);
        this.edges.add(e);
    }
}

record Edge(int u, int v, double w) {

    @Contract(pure = true)
    public @NotNull String toString() {

        return this.u + " " + this.v + " " + this.w;
    }

}
