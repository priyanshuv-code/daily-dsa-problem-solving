class Solution {
    class pair{
        int first;
        int second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public void bfs(int[][] grid,int sr,int sc,int color,boolean [][]vis){
        int m=grid.length;
        int n=grid[0].length;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(sr,sc));
        vis[sr][sc] = true;
        int ori=grid[sr][sc];
        grid[sr][sc]=color;
        while(!q.isEmpty()){
            pair curr=q.poll();
            int r=curr.first;
            int c=curr.second;

            // up -> row-1,col
            if(r>0){
                if(!vis[r-1][c] && grid[r-1][c]==ori){
                    q.add(new pair(r-1,c));
                    vis[r-1][c]=true;
                    grid[r-1][c]=color;
                }
            }
            // bottom -> row+1,col
            if((r+1)<m){
                if(!vis[r+1][c] && grid[r+1][c]==ori){
                    q.add(new pair(r+1,c));
                    vis[r+1][c]=true;
                    grid[r+1][c]=color;
                }
            }
            // left -> row,col-1
            if(c>0){
                if(!vis[r][c-1] && grid[r][c-1]==ori){
                    q.add(new pair(r,c-1));
                    vis[r][c-1]=true;
                    grid[r][c-1]=color;
                }
            }
            // right -> row,col+1
            if((c+1)<n){
                if(!vis[r][c+1] && grid[r][c+1]==ori){
                    q.add(new pair(r,c+1));
                    vis[r][c+1]=true;
                    grid[r][c+1]=color;
                }
            }
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        boolean [][]vis=new boolean[m][n];
        bfs(image,sr,sc,color,vis);
        return image;
    }
}