class Solution {
    // Function to find GCD
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to find LCM
    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b; // safer to avoid overflow
    }
    public int subarrayLCM(int[] nums, int k) {
        int n=nums.length;
        int count=0;

        for(int i=0;i<k;i++){
            int currlcm=1;

            for(int j=i;j<n;j++){
                currlcm = lcm(currlcm, nums[j]);

                if(currlcm==k){
                    count++;
                }
            }
        }
       return count; 
    }
}