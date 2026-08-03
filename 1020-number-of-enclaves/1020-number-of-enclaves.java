class pair{
    int fir;
    int sec;
    pair(int fir,int sec){
        this.fir=fir;
        this.sec=sec;
    }

}
class Solution {
    public void bfs(int [][]grid,boolean [][] vis,int rows,int cols){
        int m=grid.length;
        int n=grid[0].length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(rows,cols));
        vis[rows][cols]=true;
        int [] delrow={-1,0,1,0};
        int [] delcol={0,1,0,-1};
        while(!q.isEmpty()){
            pair t=q.poll();
            int r=t.fir;
            int c=t.sec;
            for(int i=0;i<4;i++){
                int r1=r+delrow[i];
                int c1=c+delcol[i];
                if(r1>=0 && r1<m && c1>=0 && c1<n && !vis[r1][c1] && grid[r1][c1]==1){
                    vis[r1][c1]=true;
                    q.add(new pair(r1,c1));
                }
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean [][]vis=new boolean[m][n];

        for(int i=0;i<n;i++){
            if(!vis[0][i] && grid[0][i]==1){
                bfs(grid,vis,0,i);
            }
        }
        for(int i=0;i<n;i++){
            if(!vis[m-1][i] && grid[m-1][i]==1){
                bfs(grid,vis,m-1,i);
            }
        }
        for(int i=0;i<m;i++){
            if(!vis[i][0] && grid[i][0]==1){
                bfs(grid,vis,i,0);
            }
        }
        for(int i=0;i<m;i++){
            if(!vis[i][n-1] && grid[i][n-1]==1){
                bfs(grid,vis,i,n-1);
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] &&grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}