import java.util.*;

class Solution {

    private boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        Queue<int[]> q = new LinkedList<>();

        visited[src] = true;
        q.offer(new int[]{src, -1}); // node, parent

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for (int j = 0; j < adj.get(node).size(); j++) {

                int neighbour = adj.get(node).get(j);

                if (parent == neighbour)
                    continue;

                if (visited[neighbour])
                    return true;

                visited[neighbour] = true;
                q.offer(new int[]{neighbour, node});
            }
        }

        return false;
    }

    public boolean isCycle(int V, int[][] edges) {

        // Step 1: Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Fill adjacency list (undirected graph)
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 3: BFS cycle detection
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(i, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}