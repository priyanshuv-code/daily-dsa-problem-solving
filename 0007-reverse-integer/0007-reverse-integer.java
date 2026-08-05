class Solution {
    public int reverse(int x) {
        long ans=0;
       while(x!=0){
        int a=x%10;
        ans*=10;
        ans=ans+a;
        x=x/10;
       }
       if(ans>Integer.MAX_VALUE || ans<Integer.MIN_VALUE){
        return 0;
       }
       return (int)ans;
    }
}