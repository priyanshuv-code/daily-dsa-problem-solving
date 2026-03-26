class Solution {
    public int removeDuplicates(int[] nums) {
        int count=1;
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                nums[++i]=nums[j];
                count++;
            }
        }
        return count;
    }
}