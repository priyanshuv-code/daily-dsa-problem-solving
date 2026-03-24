class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return Atmost(nums,k)-Atmost(nums,k-1);
    }
    private int Atmost(int []nums,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int count=0;
        while(j<nums.length){
            if(map.containsKey(nums[j])){
                map.put(nums[j],map.get(nums[j])+1);
            }
            else{
                map.put(nums[j],1);
            }

            while(map.size()>k){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return  count;
    }
}