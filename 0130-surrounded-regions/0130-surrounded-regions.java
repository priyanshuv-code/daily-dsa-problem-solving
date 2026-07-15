class Solution {
    class pair{
        int first;
        int second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public void bfs(char[][] board,boolean [][]vis,int row,int col){
        int m=board.length;
        int n=board[0].length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(row,col));
        vis[row][col]=true;
        while(!q.isEmpty()){
            pair curr=q.poll();
            int r=curr.first;
            int c=curr.second;

            if(r-1>=0 && vis[r-1][c]==false && board[r-1][c]=='O'){
                vis[r-1][c]=true;
                q.add(new pair(r-1,c));
            }
            if(r+1<m && vis[r+1][c]==false && board[r+1][c]=='O'){
                vis[r+1][c]=true;
                q.add(new pair(r+1,c));
            }
            if(c-1>=0 && vis[r][c-1]==false && board[r][c-1]=='O'){
                vis[r][c-1]=true;
                q.add(new pair(r,c-1));
            }
            if(c+1<n && vis[r][c+1]==false && board[r][c+1]=='O'){
                vis[r][c+1]=true;
                q.add(new pair(r,c+1));
            }
        }
    }
    public void solve(char[][] grid) {
        int m=grid.length; // row
        int n=grid[0].length; // col;

        boolean [][]vis=new boolean[m][n];

        // Top row
        for (int i = 0; i < n; i++) {
            if (!vis[0][i] && grid[0][i] == 'O') {
                bfs(grid, vis, 0, i);
            }
        }

        // Bottom row
        for (int i = 0; i < n; i++) {
            if (!vis[m - 1][i] && grid[m - 1][i] == 'O') {
                bfs(grid, vis, m - 1, i);
            }
        }

        // Left column
        for (int i = 0; i < m; i++) {
            if (!vis[i][0] && grid[i][0] == 'O') {
                bfs(grid, vis, i, 0);
            }
        }

        // Right column
        for (int i = 0; i < m; i++) {
            if (!vis[i][n - 1] && grid[i][n - 1] == 'O') {
                bfs(grid, vis, i, n - 1);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==false && grid[i][j]=='O'){
                    grid[i][j]='X';
                    vis[i][j]=true;
                }
            }
        }
    }
}