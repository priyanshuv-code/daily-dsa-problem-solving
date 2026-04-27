class Solution {
    public int findCircleNum(int[][] adj) {
        int n=adj.length;
        boolean []vis=new boolean [n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,adj,vis);
                count++;
                }
            }
            return count; 
        }
       
        private void bfs(int i,int [][] adj,boolean [] vis){
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            vis[i]=true;
            while(!q.isEmpty()){
                int node=q.poll();
                for(int j=0;j<adj.length;j++){
                    if(adj[node][j]==1 && vis[j]==false){
                        vis[j]=true;
                        q.add(j);
                    }
                }
            } 
        }
        
    }
