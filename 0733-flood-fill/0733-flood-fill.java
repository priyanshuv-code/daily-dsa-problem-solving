class Solution {
    class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void dfs(int row,int col,int[][]image,int color,int [][]ans ,int original){
        int n=image.length;
        int m=image[0].length;
        ans[row][col]=color;
        int []dr={-1,0,1,0}; 
        int []dc={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow=row+dr[i];
            int ncol=col+dc[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m 
               && image[nrow][ncol]==original 
               && ans[nrow][ncol]!=color){
            dfs(nrow,ncol,image,color,ans,original);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int [][]ans=new int [n][m];
        // ✅ IMPORTANT: copy image into ans
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j] = image[i][j];
            }
        }
        int original=image[sr][sc];
        if(original == color) return image; // imp
        dfs(sr,sc,image,color,ans,original);
        return ans;
    }
}