class Solution {
    public int trap(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        int ans=0;
        int leftmax=0;
        int rightmax=0;
        while(i<j){
            if(nums[i]<=nums[j]){
                if(nums[i]>leftmax){
                    leftmax=nums[i];
                }
                else{
                    ans += leftmax - nums[i];
                }
                i++;
            }
            else{
                if(nums[j]>rightmax){
                    rightmax=nums[j]; 
                }
                else{
                    ans+=rightmax-nums[j];
                }
                j--;
            }
        }
        return ans;
    }
}