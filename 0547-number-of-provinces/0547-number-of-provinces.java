class Solution {
    private void dfs(int node,int[][] isConnected,int[] vis){
        vis[node]=1;

        for(int j=0;j<isConnected.length;j++){
            if(isConnected[node][j]==1 && vis[j]==0){
                dfs(j,isConnected,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        int cnt=0;

        int [] vis=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,isConnected,vis);
                cnt++;
            }
        }
        return cnt;
    }
}