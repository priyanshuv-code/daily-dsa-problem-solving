class Solution {
    public void bfs(int node ,ArrayList<ArrayList<Integer>> adj,Queue<Integer> q,boolean []vis){
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
        boolean []vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,adj,q,vis);
                cnt++;
            }
        }
        return cnt;
    }
}