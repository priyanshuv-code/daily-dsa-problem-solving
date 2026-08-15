class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=0;
        int x=0;
        for(int i=0;i<=n;i++){
            sum+=x;
            x++;
        }
        for(int i=0;i<n;i++){
            sum-=nums[i];
        }
        return sum;
    }
}