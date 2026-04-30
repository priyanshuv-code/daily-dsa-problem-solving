class Solution {
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(int row,int col,int [][] vis,char [][]grid){
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row,col));
        vis[row][col]=1;
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        while(!q.isEmpty()){
            pair curr=q.poll();

            for(int i=0;i<4;i++){
                int newr=curr.row+dr[i];
                int newc=curr.col+dc[i];

                if(newr>=0 && newr<n && newc>=0 && newc<m && vis[newr][newc]==0 && grid[newr][newc]=='1'){
                    vis[newr][newc]=1;
                    q.add(new pair(newr,newc));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int [][]vis=new int[n][m];
        int cnt=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    bfs(i,j,vis,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}