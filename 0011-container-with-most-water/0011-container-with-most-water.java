class Solution {
    public int maxArea(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        int ans=0;
        while(i<j){
            int m=Math.min(nums[i],nums[j]);
            int w=j-i;
            if(nums[i]<nums[j]){
                i++;
            }
            else{
                j--;
            }
            ans=Math.max(m*w,ans); 
        }
        return ans;
    }
}