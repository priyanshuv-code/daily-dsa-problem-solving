class Solution {
    public void bfs(int node,ArrayList<ArrayList<Integer>> adj,boolean [] vis){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int curr=q.poll();

            for(int adje:adj.get(curr)){
                if(!vis[adje]){
                    vis[adje]=true;
                    q.add(adje);
                }
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
        boolean [] vis=new boolean[n];
        vis[source]=true;
        bfs(source,adj,vis);
        return vis[destination];

    }
}