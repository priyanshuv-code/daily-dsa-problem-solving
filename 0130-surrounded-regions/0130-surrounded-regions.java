class Solution {
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(int i,int j,char[][] board,int [][]vis){
        int n=board.length; // no of rows..
        int m=board[0].length; // no of cols..
        Queue<pair> q=new LinkedList<>();
        vis[i][j]=1;
        q.add(new pair(i,j));
        int [] delrow={0,-1,0,1};
        int [] delcol={1,0,-1,0};
        while(!q.isEmpty()){
            pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            for(int k=0;k<4;k++){
                int newrow=r+delrow[k];
                int newcol=c+delcol[k];
               if(newrow >= 0 && newrow < n &&
                    newcol >= 0 && newcol < m &&
                    vis[newrow][newcol] == 0 &&
                    board[newrow][newcol] == 'O'){
                    vis[newrow][newcol]=1;
                    q.add(new pair(newrow,newcol));
                }
            }
        }
    }
    public void solve(char[][] board) {
        int n=board.length; // no of rows..
        int m=board[0].length; // no of cols..

        int [][]vis=new int[n][m];
        for(int i=0;i<m;i++){
            if(vis[0][i]==0 && board[0][i]=='O'){
                bfs(0,i,board,vis);
            }
        }
        for(int i=0;i<m;i++){
            if(vis[n-1][i]==0 && board[n-1][i]=='O'){
                bfs(n-1,i,board,vis);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
                bfs(i,0,board,vis);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                bfs(i,m-1,board,vis);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}