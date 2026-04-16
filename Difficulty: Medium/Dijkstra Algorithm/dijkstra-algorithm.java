class Solution {
    class pair{
        int distance;
        int node;
        
        pair(int distance,int node){
            this.distance=distance;
            this.node=node;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            
            adj.get(u).add(new ArrayList<>(Arrays.asList(v,wt)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u,wt)));
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        
        int [] dist=new int[V];
        
        for(int i=0;i<V;i++){
            dist[i]=(int)1e9;
        }
        dist[src]=0;
        pq.add(new pair(0,src));
        
        while(!pq.isEmpty()){
            pair current=pq.poll();
            int dis=current.distance;
            int node=current.node;
            
            for(ArrayList<Integer> it:adj.get(node)){
                
                int adjNode = it.get(0);
                int edge_wt=it.get(1);
                
                if(dis+edge_wt<dist[adjNode]){
                    dist[adjNode]=dis+edge_wt;
                   pq.add(new pair(dist[adjNode], adjNode));
                }
            }
        }
        
        return dist;
        
    }
}