class Solution {
    public int minimumCardPickup(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int ans = Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while(j<nums.length){
            while(set.contains(nums[j])){
                ans=Math.min(ans,j-i+1);
                set.remove(nums[i]);
                i++;
            }
            set.add(nums[j]);
            j++;
        }
        if(ans == Integer.MAX_VALUE)return -1;
        return ans;
    }
}