class Solution {
    public int search(int[] nums, int target) {
        Arrays.sort(nums);
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
        return -1;
    }
}