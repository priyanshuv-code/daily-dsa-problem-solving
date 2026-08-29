class Solution {
    public void bfs(List<List<Integer>> rooms,int start,Queue<Integer> q,boolean [] vis){
        q.add(start);
        vis[start]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int adj:rooms.get(node)){
                if(!vis[adj]){
                    q.add(adj);
                    vis[adj]=true;
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        Queue<Integer> q=new LinkedList<>();
        boolean [] vis=new boolean[n];
        bfs(rooms,0,q,vis);
        for(int i=0;i<n;i++){
            if(!vis[i]) return false;
        }
        return true;
    }
}