class Solution {
    public void bfs(int node,Queue<Integer> q,ArrayList<ArrayList<Integer>> adj,boolean [] vis){
        vis[node]=true;
        q.add(node);
        while(!q.isEmpty()){
            int curr=q.poll();

            for(int it:adj.get(curr)){
                if(!vis[it]){
                    vis[it]=true;
                    q.add(it);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        int cnt=0;
        Queue<Integer> q=new LinkedList<>();
        boolean [] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,q,adj,vis);
                cnt++;
            }
        }
        return cnt;
    }
}