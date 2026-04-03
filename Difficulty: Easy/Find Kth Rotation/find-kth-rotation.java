class Solution {
    public int findKRotation(int nums[]) {
        // Code here
        int n=nums.length;
        int left=0;
        int right=n-1;
        
        while(left<right){
            int mid=(left+right)/2;
            
            if(nums[mid]<nums[right]){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}