class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int idx=0;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                idx=i;
                break;
            }
       }
       int ans=1;  
       for(int i=idx;i<n;i++){
        if(i != 0 && nums[i] == nums[i-1]) continue;
        if(nums[i]!=ans){
            return ans;
        }
        else{
            ans++;
        }
       }
       return ans;
    }
}