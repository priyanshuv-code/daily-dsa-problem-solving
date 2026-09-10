class Solution {
    public int f(int n,int []dp){
        if(n<=1)return n;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public int fib(int n) {
        if (n <= 1)return n;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        return f(n,dp);
    }
}