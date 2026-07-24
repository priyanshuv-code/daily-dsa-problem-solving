class pair{
    int row;
    int col;
    int time;
    pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair> q=new LinkedList<>();
        int [][] vis=new int[n][m];
        int cntfresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    cntfresh++; 
                }
            }
        }
        int tm=0;
        int []delrow={-1,0,1,0};
        int []delcol={0,1,0,-1};
        while(!q.isEmpty()){
            pair p=q.poll();

            int r=p.row;
            int c=p.col;
            int t=p.time;
            tm=Math.max(tm,t);

            for(int i=0;i<4;i++){
                int newr=r+delrow[i];
                int newc=c+delcol[i];

                if(newr>=0 && newr<n && newc>=0 && newc<m && vis[newr][newc]==0 && grid[newr][newc]==1){
                    vis[newr][newc]=2;
                    q.offer(new pair(newr,newc,t+1));
                    cntfresh--;

                }
            }
        }
        if(cntfresh!=0){
            return -1;
        }
        return tm;
    }
}