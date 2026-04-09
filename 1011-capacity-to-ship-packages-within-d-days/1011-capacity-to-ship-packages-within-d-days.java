class Solution {
    private boolean ispossible(int mid,int [] weights,int days){
        int cnt=1;
        int curr=0;

        for(int i=0;i<weights.length;i++){
            if(curr+weights[i]<=mid){
                curr+=weights[i];
            }
            else{
                curr=weights[i];
                cnt++;
            }
        }
        return cnt<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n= weights.length;
        int low=Integer.MIN_VALUE;
        int high=0;
        int ans=0;
        for(int i=0;i<n;i++){
            low=Math.max(low, weights[i]);
            high+= weights[i];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(ispossible(mid,weights,days)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}