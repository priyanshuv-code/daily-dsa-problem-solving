class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[i] == nums[mid] && nums[mid] == nums[j]){
                i++;
                j--;
                continue;
            }
            if(nums[i]<=nums[mid]){
                // means left side is sorted
                if(nums[i]<=target && target<nums[mid]){
                    j=mid-1;
                }
                else{
                    i=mid+1;
                }
            }
            else{
                if(target>nums[mid] && target<=nums[j]){
                    i=mid+1;
                }
                else{
                    j=mid-1;
                }
            }
        }
        return false;
    }
}