class Solution {
    public int findTheWinner(int n, int k) {
        int ans=r(n,k);
        return ans+1;
    }
    public int r(int n,int k){
        if(n==1)return 0;

        return (r(n-1,k)+k)%n;
    }
}