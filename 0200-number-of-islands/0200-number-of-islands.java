class Solution {
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(int i,int j,boolean [][] vis,char [][] grid){
        int m=grid.length;
        int n=grid[0].length;

        Queue<pair> q=new LinkedList<>();
        q.add(new pair(i,j));
        while(q.size()>0){
            pair f=q.remove();
            int row=f.row,  col=f.col;

            // top -> row-1,col

            if(row>0){
                if(vis[row-1][col]==false && grid[row-1][col]=='1'){
                    q.add(new pair(row-1,col));
                    vis[row-1][col]=true;
                }
            }
            // bottom -> row+1,col;

            if((row+1)<m){
                if(vis[row+1][col]==false && grid[row+1][col]=='1'){
                    vis[row+1][col]=true;
                    q.add(new pair(row+1,col));
                }
            }
            // right -> row,col+1;
            if((col+1)<n){
                if(vis[row][col+1]==false && grid[row][col+1]=='1'){
                    vis[row][col+1]=true;
                    q.add(new pair(row,col+1));
                }
            }
            // left -> row,col-1;
            if(col>0){
                if(vis[row][col-1]==false && grid[row][col-1]=='1'){
                    vis[row][col-1]=true;
                    q.add(new pair(row,col-1));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int cnt=0;
        boolean [][]vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    bfs(i,j,vis,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}