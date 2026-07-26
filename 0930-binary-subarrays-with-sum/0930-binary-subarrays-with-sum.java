class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return Atmost(nums,goal)-Atmost(nums,goal-1);
    }
    public static int Atmost(int []nums,int goal){
        if(goal<0)return 0;

        int sum=0;
        int i=0;
        int j=0;
        int cnt=0;
        while(j<nums.length){
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