class Solution {
    private boolean bfs(int start,int [][]graph,int []vis){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        vis[start]=0;

        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();

            for(int it:graph[node]){
                if(vis[it]==-1){
                    vis[it]=1-vis[node];
                    q.add(it);
                }
                else if(vis[it]==vis[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;

        int [] vis=new int [V];

        for(int i=0;i<V;i++){
            vis[i]=-1;
        }

        for(int i=0;i<V;i++){
            if(vis[i]==-1){
                if(bfs(i,graph,vis)==false){
                    return false;
                }
                
            }
        }
        return true;
    }
}