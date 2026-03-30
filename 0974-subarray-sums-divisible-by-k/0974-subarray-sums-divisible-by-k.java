class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int res=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod=sum%k;
            if(mod<0){
                mod=mod+k;
            }
            if(map.containsKey(mod)){
                res +=map.get(mod);
            }
            map.put(mod,map.getOrDefault(mod,0)+1);
            
        }
        return res;
        
    }                                                                 
}