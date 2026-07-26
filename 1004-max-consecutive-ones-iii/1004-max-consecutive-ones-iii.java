class Solution {
    public int longestOnes(int[] nums, int k) {
        int one=0;
        int ans=0;
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[j]==1)one++;

            while(j-i+1-one>k){
                if(nums[i]==1)one--;
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}