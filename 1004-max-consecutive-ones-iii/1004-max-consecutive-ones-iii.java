class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int j=0;
        int max_freq=0;
        int ans=0;
        while(j<n){
            if(nums[j]==1)max_freq++;
            while(j-i+1-max_freq>k){
                if(nums[i]==1)max_freq--;
                i++;   
            }
            ans=Math.max(ans,j-i+1);
            j++;    
        }
        return ans;
    }
}