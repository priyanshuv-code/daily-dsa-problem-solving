class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        long sum=0;
        long ans=0;
        while(j<nums.length){
            sum+=nums[j];
            if(map.containsKey(nums[j])){
                map.put(nums[j],map.get(nums[j])+1);
            }
            else{
                map.put(nums[j],1);
            }
            while(map.get(nums[j])>1){
                sum-=nums[i];
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0)map.remove(nums[i]);
                i++;
            }
            if(j-i+1>k){
                sum-=nums[i];
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0)map.remove(nums[i]);
                i++;
            }
            if(j-i+1==k){
                ans=Math.max(ans,sum);
            }
            j++;
        }
        return ans; 
    }
}