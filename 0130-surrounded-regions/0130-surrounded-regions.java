class pair{
    int row;
    int col;
    pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public void bfs(char [][] board,boolean [][]vis,int rows,int cols){
        int m=board.length; // row; 
        int n=board[0].length; //col
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(rows,cols));
        vis[rows][cols]=true;
        int [] delrow={-1,0,1,0};
        int [] delcol={0,1,0,-1};
        while(!q.isEmpty()){
            pair top=q.poll();
            int r=top.row;
            int c=top.col;
            for(int i=0;i<4;i++){
                int nr=delrow[i]+r;
                int nc=delcol[i]+c;
                if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==false && board[nr][nc]=='O'){
                    vis[nr][nc]=true;
                    q.add(new pair(nr,nc));
                }
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean [][]vis=new boolean[m][n];
        for(int i=0;i<n;i++){
            if(!vis[0][i] && board[0][i]=='O'){
                bfs(board, vis, 0, i);
            }
        }
        for(int i=0;i<n;i++){
            if(!vis[m-1][i] && board[m-1][i]=='O'){
                bfs(board, vis, m-1, i);
            }
        }
        for(int i=0;i<m;i++){
            if(!vis[i][0] && board[i][0]=='O'){
                bfs(board, vis, i, 0);
            }
        }
        for(int i=0;i<m;i++){
            if(!vis[i][n-1] && board[i][n-1]=='O'){
                bfs(board, vis, i, n-1);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j]=='O'){
                    vis[i][j]=true;
                    board[i][j]='X';
                }
            }
        }

    } 
}