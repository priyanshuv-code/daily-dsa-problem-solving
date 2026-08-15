class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int []ans={0,0};
        for(int i=0;i<n;i++){
            int diff=target-nums[i];
            if(map.containsKey(diff)){
                ans[0]=map.get(diff);
                ans[1]=i;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return ans;
    }
}