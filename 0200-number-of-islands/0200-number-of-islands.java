class Solution {
    public void dfs(int r,int c,char[][] grid,boolean[][] vis,int []row,int []col){
        int n=grid.length;
        int m=grid[0].length;
        vis[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+row[i];
            int cr=c+col[i];
            if(nr >= 0 && nr < n && cr >= 0 && cr < m
        && !vis[nr][cr] && grid[nr][cr] == '1'){
                dfs(nr,cr,grid,vis,row,col);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean [][] vis=new boolean[n][m];
        int []row={0,1,-1,0};
        int []col={-1,0,0,1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(i,j,grid,vis,row,col);
                    count++;
                }
            }
        }
        return count;
    }
}