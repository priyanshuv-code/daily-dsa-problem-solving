class Solution {
    public boolean ispossible(int [] nums,int mid,int k){
        int cnt=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>mid){
                cnt++;
                sum=nums[i];
            }
            else{
                sum+=nums[i];
            }
        }
        return cnt<=k;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int start=0;
        int end=0;
        int ans=0;
        for(int i=0;i<n;i++){
            start=Math.max(start,nums[i]);
            end+=nums[i];
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if(ispossible(nums,mid,k)){
                ans=mid;
                end=mid-1;
            }  
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}