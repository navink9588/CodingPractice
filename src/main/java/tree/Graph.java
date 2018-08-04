package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author FogHorn Systems, Inc.
 */
public class Graph {
    private Map<Integer, LinkedList<Integer>> adjacent;

    Graph() {
        this.adjacent = new HashMap<>();
    }

    void addEdge(int v, int w) {
        if(!adjacent.containsKey(v)) {
            adjacent.put(v, new LinkedList<>());
        }
        adjacent.get(v).add(w);
    }

    public int size() {
        return adjacent.size();
    }

    LinkedList<Integer> adjacent(int v) {
        return adjacent.get(v);
    }

    public void print() {
        for(Map.Entry<Integer, LinkedList<Integer>> entry : adjacent.entrySet()) {
            Integer curr = entry.getKey();
            LinkedList<Integer> adj = entry.getValue();
            if(adj != null) {
                for(Integer a : adj) {
                    System.out.printf("%d --> %d\n", curr, a);
                }
            }
        }
    }
}
