class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid]>target){
                j--;
            }
            else{
                i++;
            }
        }
        return i;
    }
}
