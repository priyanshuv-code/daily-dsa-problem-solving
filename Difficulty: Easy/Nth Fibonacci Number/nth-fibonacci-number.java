class Solution {
    static int nthFibonacci(int n) {
        // code here
        if(n==0 || n==1)return n;
        return nthFibonacci(n-2)+ nthFibonacci(n-1);
        
    }
}