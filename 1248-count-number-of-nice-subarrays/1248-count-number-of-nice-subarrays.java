class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return g(nums,k)-g(nums,k-1);
    }
    public static int g(int[] nums, int k){
        int odd_cnt=0;
        int i=0;
        int j=0;
        int ans=0;
        while(j<nums.length){
            if(nums[j]%2!=0)odd_cnt++;
            while(odd_cnt>k){
                if(nums[i]%2!=0)odd_cnt--;
                i++;
            }
            ans+=j-i+1;
            j++;
        }
        return ans;
    }
}