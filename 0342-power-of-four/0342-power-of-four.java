class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<0) return false;
        long ans=1;
        while(ans<=n){
            if(ans==n)return true;
            ans*=4;
        }
        return false;
    }
}