class Solution {
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public  int bfs(int row,int col,int [][]vis,int [][]grid){
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row,col));
        vis[row][col] = 1;
        int cnt=1;
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        while(!q.isEmpty()){
            pair curr=q.poll();
            for(int i=0;i<4;i++){
                int nrow=curr.row+dr[i];
                int ncol=curr.col+dc[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    cnt++;
                    vis[nrow][ncol]=1;
                    q.add(new pair(nrow,ncol));
                }
            }
            
        }
        return cnt;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int [][] vis=new int[n][m];
        int max=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    int area=bfs(i,j,vis,grid);
                    max=Math.max(max,area);
                }
            }
        }
        return max;
        
    }
}