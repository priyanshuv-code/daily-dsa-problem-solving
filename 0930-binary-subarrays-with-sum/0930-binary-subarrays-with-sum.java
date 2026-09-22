class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return g(nums,goal)-g(nums,goal-1);
    }
    public static int g(int[] nums, int k){
        int i=0;
        int j=0;
        int n=nums.length;
        int sum=0;
        int cnt=0;
        while(j<n){
            if(k<0)return 0;
            sum+=nums[j];
            while(sum>k){
                sum-=nums[i];
                i++;
            }
            cnt+=j-i+1;
            j++;
        }
        return cnt;
    }
}