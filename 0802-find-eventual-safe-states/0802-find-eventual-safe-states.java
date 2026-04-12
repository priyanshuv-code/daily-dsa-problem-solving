class Solution {
    private boolean dfs(int node,List<List<Integer>> adj,int []vis,int []pathvis,int []check){
        vis[node]=1;
        pathvis[node]=1;

        for(int it:adj.get(node)){
            if(vis[it]==0){
                if(dfs(it,adj,vis,pathvis,check)==true){
                    return true;
                }
                
            }
            // if already in same path → cycle
            else if(pathvis[it]==1){
                return true;
            }
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < V; i++) {
            for(int it : graph[i]) {
                adj.get(i).add(it);
            }
        }
        int []vis=new int[V];
        int []pathvis=new int[V];
        int []check=new int[V];

        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,adj,vis,pathvis,check);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i = 0; i < V; i++) {
            if(check[i] == 1)
                ans.add(i);
        }

        return ans;
    }
}