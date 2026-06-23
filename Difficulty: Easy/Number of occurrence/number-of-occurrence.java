class Solution {
    int countFreq(int[] nums, int target) {
        // code here
        int first = seachfirst(nums, target);

        if(first == -1) return 0; // target not found

        int last = seachlast(nums, target);

        return last - first + 1;
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
