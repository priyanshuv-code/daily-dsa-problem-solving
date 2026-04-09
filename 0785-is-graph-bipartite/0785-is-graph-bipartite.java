class Solution {
    private boolean dfs(int node,int color,int [] visited,int[][] graph){
        visited[node]=color;

        for(int it:graph[node]){
            if(visited[it]==-1){
                if(dfs(it,1-visited[node],visited,graph)==false){
                    return false;
                }
            }
            else if(visited[it]==visited[node]){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int [] visited=new int[V];

        for(int i=0;i<V;i++) visited[i]=-1;

        for(int i=0;i<V;i++){
            if(visited[i]==-1){
                if(dfs(i,0,visited,graph)==false){
                    return false;
                }
            }
        }
        return true;
    }
}