class Solution {
    public boolean bfs(int start,int V,ArrayList<ArrayList<Integer>> adj,int []col){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        col[start]=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int adje:adj.get(curr)){
                if(col[adje]==-1){
                    col[adje]=1-col[curr];
                    q.add(adje);
                }
                else if(col[adje]==col[curr]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j : graph[i]) {
                adj.get(i).add(j);
            }
        }
        int []col=new int[V];
        for(int i=0;i<V;i++){
            col[i]=-1;
        }
        for(int i=0;i<V;i++){
            if(col[i]==-1){
                if(bfs(i,V,adj,col)==false)return false;
            }
        }
        return true;
    }
}