class Solution {

    // DFS function
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                        int[] vis, int[] pathvis, int[] check) {

        vis[node] = 1;
        pathvis[node] = 1;

        for(int it : adj.get(node)) {

            // not visited
            if(vis[it] == 0) {
                if(dfs(it, adj, vis, pathvis, check)) {
                    check[node] = 0;   // mark unsafe
                    return true;
                }
            }
            // cycle detected
            else if(pathvis[it] == 1) {
                check[node] = 0;       // mark unsafe
                return true;
            }
        }

        // safe node
        check[node] = 1;
        pathvis[node] = 0;

        return false;
    }

    public ArrayList<Integer> safeNodes(int V, int[][] edges) {

        // Step 1: create adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: build graph (u → v)
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        // Step 3: arrays
        int[] vis = new int[V];
        int[] pathvis = new int[V];
        int[] check = new int[V];

        // Step 4: DFS on all nodes
        for(int i = 0; i < V; i++) {
            if(vis[i] == 0) {
                dfs(i, adj, vis, pathvis, check);
            }
        }

        // Step 5: collect safe nodes
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            if(check[i] == 1) {
                ans.add(i);
            }
        }

        return ans;
    }
}