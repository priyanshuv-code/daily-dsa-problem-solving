class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int []ans=new int[k];
        for(int i=0;i<k;i++){
            int max_f=-1;
            int max_val=-1;
            for(int f:map.keySet()){
                if(map.get(f)>max_val){
                    max_f=f;
                    max_val=map.get(f);
                }
            }
            ans[i]=max_f;
            map.remove(max_f);

        }
        return ans;
    }
}