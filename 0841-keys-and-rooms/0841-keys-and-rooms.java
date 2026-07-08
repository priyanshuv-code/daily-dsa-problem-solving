class Solution {
    public void bfs(int node,ArrayList<ArrayList<Integer>> adj,boolean [] vis,Queue<Integer> q){ 
        q.add(node);
        vis[node]=true;
        
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
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int it:rooms.get(i)){
                adj.get(i).add(it);
            }
        }
        boolean[] vis=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        bfs(0,adj,vis,q);
        for(int i=0;i<n;i++){
            if(vis[i]==false)return false;
        }
        return true;
    }
}