class Solution {
    public long maximumSubarraySum(int[] nums, int k) { 
        HashMap<Integer,Integer> map=new HashMap<>();
        long max=0;
        int i=0;
        int j=0; 
        long sum=0;
        while(j<nums.length){
            if(map.containsKey(nums[j])){
                map.put(nums[j],map.get(nums[j])+1);
            }
            else{
                map.put(nums[j],1);
            }
            sum+=nums[j];

            while(map.get(nums[j])>1){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                sum-=nums[i];
                i++;
            }

            if(j-i+1==k){
                max=Math.max(max,sum);
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0)map.remove(nums[i]);
                sum=sum-nums[i];
                i++;
            }
            j++;
        }
        return max;
    }
}