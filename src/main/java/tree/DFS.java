package tree;

import java.util.LinkedList;

/**
 * @author FogHorn Systems, Inc.
 */
public class DFS {
    Graph graph;

    public DFS() {
        graph = new Graph();
    }

    public void dfs(int s) {
        boolean[] visited = new boolean[graph.size()];

        util(s, visited);
    }

    private void util(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");

        LinkedList<Integer> adjacent = graph.adjacent(s);
        if(adjacent != null) {
            for(int v : adjacent) {
                if(!visited[v]) {
                    util(v, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        dfs.graph.addEdge(0, 1);
        dfs.graph.addEdge(0, 2);
        dfs.graph.addEdge(1, 2);
        dfs.graph.addEdge(2, 0);
        dfs.graph.addEdge(2, 3);
        dfs.graph.addEdge(3, 3);
        dfs.graph.addEdge(2, 4);
        dfs.graph.addEdge(5, 2);
        dfs.graph.addEdge(4, 5);

        dfs.graph.print();

        dfs.dfs(2);
    }
}
