class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans=Integer.MAX_VALUE;
        int n=nums.length;
        int i=0;
        int j=0;
        int sum=0;
        while(j<n){
            sum+=nums[j];
            while(sum>=target){
                sum-=nums[i];
                ans=Math.min(ans,j-i+1);
                i++;
            }
            j++;
        }
        if(ans==Integer.MAX_VALUE)return 0;
        return ans;
    }
}