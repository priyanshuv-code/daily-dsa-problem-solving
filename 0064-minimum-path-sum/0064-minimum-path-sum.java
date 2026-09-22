class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][] dp=new int[m][n]; 
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(m-1,n-1,grid,dp);
    }
    public static int f(int i,int j,int[][] grid ,int [][]dp){
        if(i<0 || j<0)return Integer.MAX_VALUE;
        if(i==0 && j==0)return grid[i][j];
        if(dp[i][j]!=-1)return dp[i][j];
        int top=f(i-1,j,grid,dp);
        int left=f(i,j-1,grid,dp);
        dp[i][j] =grid[i][j]+Math.min(top,left);
        return dp[i][j];
    }
}