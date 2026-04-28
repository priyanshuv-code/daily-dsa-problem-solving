class Solution {
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(int start,int row,int [][]vis,char[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        Queue<pair> q=new LinkedList<>();
        q.add(new pair(start,row));
        vis[start][row]=1;
        int []dr={-1,0,0,1};
        int []dc={0,-1,1,0};
        while(!q.isEmpty()){
            pair curr=q.poll();

            for(int i=0;i<4;i++){
                int rowr=curr.row+dr[i];
                int colc=curr.col+dc[i];

                if(rowr>=0 && rowr<n &&  colc>=0 && colc<m &&  grid[rowr][colc]=='1' && vis[rowr][colc]==0){
                    q.add(new pair(rowr,colc));
                    vis[rowr][colc]=1;
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        int n=grid.length;
        int m=grid[0].length;
        int [][]vis=new int[n][m];

        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    bfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    } 
}