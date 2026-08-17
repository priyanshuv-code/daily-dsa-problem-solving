class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long max=0;
        long sum=0;
        int i=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int j=0;j<n;j++){
            sum+=nums[j];
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(j-i+1==k){
                if(map.size()==k){
                    max=Math.max(max,sum);
                }
                sum-=nums[i];
                if(map.containsKey(nums[i])){
                    if(map.get(nums[i])>0){
                        map.put(nums[i],map.get(nums[i])-1);
                    }
                    if(map.get(nums[i])==0)map.remove(nums[i]);
                }
               i++; 
            }
        }
        return max;
    }
}