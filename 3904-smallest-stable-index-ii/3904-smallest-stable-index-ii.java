class Solution {
    public int firstStableIndex(int[] nums, int k) {
       int n=nums.length;
       int [] premax=new int[n];
       premax[0]=nums[0];
       int [] suffmin=new int [n];
       suffmin[n-1]=nums[n-1];
       for(int i=1;i<n;i++){
        premax[i]=Math.max(premax[i-1],nums[i]);
       }
       for(int i=n-2;i>=0;i--){
        suffmin[i]=Math.min(suffmin[i+1],nums[i]);
       }
       int ans=-1;
       for(int i=0;i<n;i++){
        if((premax[i]-suffmin[i])<=k){
            ans=i;
            break;
        }
       }
       return ans;
    }
}