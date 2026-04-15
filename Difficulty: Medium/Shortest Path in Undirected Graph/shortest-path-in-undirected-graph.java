class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        
        int m=edges.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int [] dist=new int [V];
        for(int i=0;i<V;i++){
            dist[i]=(int)1e9;
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        dist[src]=0;
        while(!q.isEmpty()){
            int node=q.poll();
            
            for(int it:adj.get(node)){
                if(dist[node]+1<dist[it]){
                    dist[it]=dist[node]+1;
                    q.add(it);
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==1e9){
                dist[i]=-1;
            }
        }
        return dist;
    }
}
