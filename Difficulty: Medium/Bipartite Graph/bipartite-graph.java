import java.util.*;

class Solution {

    private boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, int[] vis) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int it : adj.get(node)) {

                if (vis[it] == -1) {
                    vis[it] = 1 - vis[node];
                    q.add(it);
                }
                else if (vis[it] == vis[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int V, int[][] edges) {

        // 🔥 Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);
            adj.get(v).add(u);   // undirected graph
        }

        // 🔥 Step 2: BFS Coloring
        int[] vis = new int[V];
        Arrays.fill(vis, -1);

        for (int i = 0; i < V; i++) {
            if (vis[i] == -1) {
                if (!bfs(i, adj, vis)) {
                    return false;
                }
            }
        }

        return true;
    }
}