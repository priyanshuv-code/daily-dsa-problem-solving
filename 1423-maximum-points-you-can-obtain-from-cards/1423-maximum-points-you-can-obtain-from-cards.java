class Solution {
    public int maxScore(int[] nums, int k) {
        int n=nums.length;
        int ls_sum=0;
        int max=0;
        for(int i=0;i<k;i++)ls_sum+=nums[i];
        max=ls_sum;
        int rs_sum=0;
        int rs_idx=n-1;
        for(int i=k-1;i>=0;i--){
            ls_sum-=nums[i];
            rs_sum+=nums[rs_idx];
            rs_idx--;
            max=Math.max(max,ls_sum+rs_sum);
        }
        return max;
    }
}