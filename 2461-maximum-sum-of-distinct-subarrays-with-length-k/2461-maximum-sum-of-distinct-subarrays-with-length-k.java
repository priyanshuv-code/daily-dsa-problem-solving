class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        int i=0;
        int j=0;
        long sum=0;
        long ans=0;
        while(j<n){
            sum+=nums[j];
            while(set.contains(nums[j]) ){
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
            
            if(j-i+1>k){
                sum=sum-nums[i];
                set.remove(nums[i]);
                i++;
            }
            if(j-i+1==k){
                ans=Math.max(ans,sum);
            }
            set.add(nums[j]);
            j++;
        }
        return ans;
    }
}