class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if (goal == 0) {
            return Atmost(nums, 0);
        }
        return Atmost(nums,goal)-Atmost(nums,goal-1);
    }
    public int Atmost(int [] nums,int goal){
        int n=nums.length;
        int i=0;
        int j=0;
        int sum=0; 
        int cnt=0;
        while(j<n){
            sum+=nums[j];
            while(sum>goal){
                sum-=nums[i];
                i++;
            }
            cnt+=j-i+1;
            j++;
        }
        return cnt;
    }
}