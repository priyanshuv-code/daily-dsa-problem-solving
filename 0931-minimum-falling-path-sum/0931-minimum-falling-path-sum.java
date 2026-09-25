class Solution {

    public int f(int i, int j, int[][] mat,int [][]dp) {

         if (j < 0 || j >= mat[0].length){
            return 100000000;
        }
        if(i == mat.length) return 0;
        if(dp[i][j]!=100000000)return dp[i][j];
        int d=mat[i][j]+f(i+1,j-1,mat,dp);
        int l=mat[i][j]+f(i+1,j,mat,dp);
        int r=mat[i][j]+f(i+1,j+1,mat,dp);
        dp[i][j]=Math.min(d,Math.min(l,r));
        return dp[i][j];
    }

    public int minFallingPathSum(int[][] mat) {

        int n=mat.length;
        int m=mat[0].length;
        int [][]dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=100000000;
            }
        }
        int ans =100000000;
        for(int j=0;j<m;j++){
            ans=Math.min(ans,f(0,j,mat,dp));
        }
        return ans;
    }
}