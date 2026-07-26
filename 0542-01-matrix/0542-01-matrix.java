class pair{
    int row;
    int col;
    int steps;
    pair(int row,int col,int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][]vis=new int[n][m];
        int [][]dist=new int[n][m];
        Queue<pair> q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    q.offer(new pair(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        int []delrow={-1,0,1,0};
        int []delcol={0,1,0,-1};
        while(!q.isEmpty()){
            pair curr=q.poll();
            int row=curr.row;
            int col=curr.col;
            int steps=curr.steps;
            dist[row][col]=steps;
            for(int i=0;i<4;i++){
                int nrow=curr.row+delrow[i];
                int ncol=curr.col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.offer(new pair(nrow,ncol,steps+1));
                    
                }
            }
        }
        return dist;
    }
}
