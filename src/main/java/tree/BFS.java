package tree;

import java.util.LinkedList;

/**
 * @author FogHorn Systems, Inc.
 */
public class BFS {

    private Graph graph;

    private BFS() {
        graph = new Graph();
    }

    private void bfs(int s) {
        boolean[] visited = new boolean[graph.size()];

        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            LinkedList<Integer> adjacent = graph.adjacent(s);
            if(adjacent != null) {
                for(int v : adjacent) {
                    if(!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        bfs.graph.addEdge(0, 1);
        bfs.graph.addEdge(0, 2);
        bfs.graph.addEdge(1, 2);
        bfs.graph.addEdge(2, 0);
        bfs.graph.addEdge(2, 3);
        bfs.graph.addEdge(3, 3);
        bfs.graph.addEdge(2, 4);
        bfs.graph.addEdge(5, 2);
        bfs.graph.addEdge(4, 5);

        bfs.graph.print();

        bfs.bfs(2);
    }

}
