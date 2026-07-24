class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int ans=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int diff=sum-k;
            if(map.containsKey(diff)){
                ans+=map.get(diff);
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }
            else{
                map.put(sum,1);
            }
        }
        return ans;
        
    }
}