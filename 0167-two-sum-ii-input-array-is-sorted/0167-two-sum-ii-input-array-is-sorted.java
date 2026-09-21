class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        int []ans={-1,-1};
        while(i<j){
            int sum=nums[i]+nums[j];
            if(sum==target){
                ans[0]=i+1;
                ans[1]=j+1;
                return ans;
            }
            else if(sum>target)j--;
            else i++;
        }
        return ans;
    }
}