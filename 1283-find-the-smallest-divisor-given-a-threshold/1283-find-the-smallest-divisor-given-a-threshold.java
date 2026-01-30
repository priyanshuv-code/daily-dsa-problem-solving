class Solution {
    private int isdiviser(int []nums,int mid){
        int sum=0;
        for(int num:nums){
            sum+=(num+mid-1)/mid;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {

        int low=1;
        int high=0;

        for(int i=0;i<nums.length;i++){
            high=Math.max(nums[i],high);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(isdiviser(nums,mid)<=threshold){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}