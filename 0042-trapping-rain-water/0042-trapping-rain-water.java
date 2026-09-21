class Solution {
    public int trap(int[] nums) {
        int n=nums.length;
        int left_max=Integer.MIN_VALUE;
        int right_max=Integer.MIN_VALUE;
        int left=0;
        int right=n-1;
        int cnt=0;
        while(left<right){
            if(nums[left]<nums[right]){
                if(nums[left]<left_max){
                    cnt+=left_max-nums[left]; 
                }
                else{
                    left_max=Math.max(left_max,nums[left]);
                }
                left++;
            }
            else{
                if(nums[right]<right_max){
                    cnt+=right_max-nums[right]; 
                }
                else{
                    right_max=Math.max(right_max,nums[right]);
                }
                right--;
            }
        }
        return cnt;
    }
}