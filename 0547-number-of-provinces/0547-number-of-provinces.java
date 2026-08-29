class Solution {
    public void bfs(int start,ArrayList<ArrayList<Integer>> list,Queue<Integer> q,boolean [] vis){
        q.add(start);
        vis[start]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int adj:list.get(node)){
                if(!vis[adj]){
                    q.add(adj);
                    vis[adj]=true;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        Queue<Integer> q=new LinkedList<>();
        boolean []vis=new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                list.get(i).add(j);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,list,q,vis);
                cnt++;
            }
        }
        return cnt;
    }
}