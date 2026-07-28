class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []ans=new int[2];
        ans[0]=binary_fir(nums,target);
        ans[1]=binary_last(nums,target);
        return ans;
    }
    public static int binary_fir(int []nums,int target){
        int i=0;
        int j=nums.length-1;
        int ans=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target){
                ans=mid;;
                j=mid-1;;
            }
            else if(nums[mid]>target){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return ans;
    }
    public static int binary_last(int []nums,int target){
        int i=0;
        int j=nums.length-1;
        int ans=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==target){
                ans=mid;
                i=mid+1;
            }
            else if(nums[mid]>target){
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return ans;
    }
}