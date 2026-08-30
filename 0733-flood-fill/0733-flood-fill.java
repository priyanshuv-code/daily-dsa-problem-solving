class Solution {
    public void dfs(int r,int c,int[][] image,boolean [][]vis,int orginal,int color){
        int m=image.length;
        int n=image[0].length;
         int []row={-1,0,1,0};
         int []col={0,1,0,-1};
         vis[r][c]=true;
         image[r][c]=color;
         for(int i=0;i<4;i++){
            int newr=r+row[i];
            int newc=c+col[i];
            if(newr>=0  &&newr<m && newc>=0 && newc<n && !vis[newr][newc] && image[newr][newc]==orginal){
                dfs(newr,newc,image,vis,orginal,color);
            }
         }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length; // no of rows;
        int n=image[0].length; // no of cols;
        int orginal = image[sr][sc];
        boolean [][]vis=new boolean[m][n];
        dfs(sr,sc,image,vis,orginal,color);
        return image;   
    }
}