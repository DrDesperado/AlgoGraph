package org.algo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphAsAdjacencyList extends HashMap<Integer, List<Integer>>{
    protected Map<Integer, List<Integer>> graph = new HashMap<>();
    public void setGraph(int Node, List<Integer> Edges) {
        graph.put(Node, Edges);
    }


}