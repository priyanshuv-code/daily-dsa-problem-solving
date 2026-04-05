class Solution {
    static class Node{
        int row,col,dist;
        
        Node(int r,int c,int d){
            row=r;
            col=c;
            dist=d;
        }
    }
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        // code here
        int n=grid.length;
        int m=grid[0].length;
        
        int [][]vis=new int[n][m];
        int [][]dist=new int[n][m];
        
        Queue<Node> q=new LinkedList<>();
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    vis[i][j]=1;
                    q.offer(new Node(i,j,0));
                }
            }
        }
        // directions: up, right, down, left
        int []delrow={-1,0,1,0};
        int []delcol={0,1,0,-1};
        
        while(!q.isEmpty()){
            Node node=q.poll();
            
            int row=node.row;
            int col=node.col;
            int steps=node.dist;
            
            dist[row][col]=steps;
            
            for(int i=0;i<4;i++){
                int newr=row+delrow[i];
                int newc=col+delcol[i];
                
                if(newr>=0 && newr<n && newc>=0 && newc<m && vis[newr][newc]==0){
                    vis[newr][newc]=1;
                    q.offer(new Node(newr,newc,steps+1));
                }
            }
        }
         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                rowList.add(dist[i][j]);
            }
            ans.add(rowList);
        }

        return ans;
    }
}