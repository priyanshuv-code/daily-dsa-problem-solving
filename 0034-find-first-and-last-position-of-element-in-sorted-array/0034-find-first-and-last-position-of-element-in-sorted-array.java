class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        if(n==1){
            if(nums[0]==target) return new int[]{0,0};
        }
        int []ans=new int[2];
        ans[0]=seachfirst(nums,target);
        ans[1]=seachlast(nums,target);
        return ans;
    }
    public int seachfirst(int []nums,int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                ans=mid;
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    } 
    public int seachlast(int []nums,int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                ans=mid;
                low=mid+1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}