class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int cnt=1;
        int max=1;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                cnt++;
            }
            else{
                cnt=1;
            }
            if(cnt>max){
                max=cnt;
            }
        }
        return max;
    }
}