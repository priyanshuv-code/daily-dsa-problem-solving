class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=0;
        int sum=0;
        int ans=0;
        HashSet<Integer> set=new HashSet<>();
        while(j<n){
            
            while(set.contains(nums[j])){
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
            sum+=nums[j];
            set.add(nums[j]);
            ans=Math.max(ans,sum);
            j++;
        }
        return ans;
    }
}