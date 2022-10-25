package org.algo;

import java.util.Arrays;

public class GraphAsAdjacencyMatrix {
    private final int n;
    private final double[][] adj;


    public GraphAsAdjacencyMatrix(int n) {
        this.n = n;
        this.adj = new double[n][n];
    }

    public int getN() {
        return n;
    }

    public void setMatrix(int row, int column, double value) {
        adj[row][column] = value;
    }

    public double[][] getAdj() {
        return adj;
    }

    public void printAdj() {
        System.out.println(Arrays.deepToString(this.adj));
    }


}
