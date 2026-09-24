class Solution {
    public boolean checkSubarraySum(int[] nums, int k) { 
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0, -1);
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int diff=sum%k;
            // if (diff < 0) diff+= k;
            if(map.containsKey(diff)){
                if(i-map.get(diff)>=2){
                    return true;
                }
            }else{
                map.put(diff,i);
            }
        }
        return false;
    }
} 