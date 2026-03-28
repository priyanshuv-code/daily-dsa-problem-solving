class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        return Atmost(nums,k)-Atmost(nums,k-1);
    }
    private int Atmost(int []nums,int k){
        if(k<0)return 0;
        int count=0;
        int i=0;
        int n=nums.length;
        int sum=0;
        int j=0;
        while(j<n){
            sum+=nums[j];

            while(sum>k){
                if(nums[i]==1){
                    sum-=nums[i];
                }
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
}