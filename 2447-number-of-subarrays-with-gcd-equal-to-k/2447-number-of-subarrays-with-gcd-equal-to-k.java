class Solution {
    public int gcd(int a, int b) {
       while(b!=0){
        int temp=b;
        b=a%b;
        a=temp;
       }
       return a;
    }
    public int subarrayGCD(int[] nums, int k) {
        int n=nums.length;
        int count=0;

        for(int i=0;i<n;i++){
            int gcdcurr=0;

            for(int j=i;j<n;j++){
                gcdcurr=gcd(gcdcurr,nums[j]);
                if(gcdcurr==k){
                    count++;
                }
            }
        }
        return count;
        
    }
}