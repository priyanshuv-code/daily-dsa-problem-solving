class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        ArrayList<Integer> list=new ArrayList<>();
        for(int a:nums){
            list.add(a);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int min=nums[0];
        int max=nums[n-1];
        while(min!=max){
            if(!list.contains(min)){
                ans.add(min);
            }
            min++;
        }
        return ans;
    }
}