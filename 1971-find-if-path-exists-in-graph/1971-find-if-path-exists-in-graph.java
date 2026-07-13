class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean []vis,int source){
        vis[source]=true;

        for(int a:adj.get(source)){
            if(!vis[a]){
                dfs(adj,vis,a);
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean []vis=new boolean[n];
        dfs(adj,vis,source);
        return vis[destination];
    }
}