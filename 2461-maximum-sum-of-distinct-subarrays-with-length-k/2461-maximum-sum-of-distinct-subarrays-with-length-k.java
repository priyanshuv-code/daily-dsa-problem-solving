class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max=0;

        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        long sum=0;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            if(map.containsKey(nums[j])){
                map.put(nums[j],map.get(nums[j])+1);
            }
            else{
                map.put(nums[j],1);
            }
            if(j-i+1==k){
                if(map.size()==k){
                    max=Math.max(max,sum);
                }
                sum-=nums[i];
                map.put(nums[i],map.get(nums[i])-1);

                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                i++;
            }
        }
        return max;
    }
}