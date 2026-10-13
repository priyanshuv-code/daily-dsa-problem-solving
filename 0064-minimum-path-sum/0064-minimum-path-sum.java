class Solution {
    public int f(int [][]grid,int i,int j,int [][]dp){
        if(i==0 && j==0)return grid[i][j];
        if(i<0 || j<0)return Integer.MAX_VALUE;
        if(dp[i][j]!=-1)return dp[i][j];
        int up=f(grid,i-1,j,dp);
        int left=f(grid,i,j-1,dp);
        dp[i][j]=grid[i][j]+Math.min(up,left);
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][]dp=new int [n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(grid,n-1,m-1,dp);
    }
}                