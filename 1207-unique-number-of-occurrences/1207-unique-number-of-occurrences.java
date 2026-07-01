class Solution {
    public boolean uniqueOccurrences(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        HashSet<Integer> set=new HashSet<>();
        for(int freq:map.values()){
            if(set.contains(freq)){
                return false;
            }
            else{
                set.add(freq);
            }
        }
        return true;
    }
}