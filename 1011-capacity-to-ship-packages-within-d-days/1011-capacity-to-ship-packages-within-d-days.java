class Solution {
    public boolean isPossible(int []weights,int days,int mid){
        int n=weights.length;
        int cnt=1;
        int sum=0;
        for(int i=0;i<n;i++){
            if(sum+weights[i]>mid){
                cnt++;
                sum=weights[i];
            }
            else{
                sum+=weights[i];
            }
        }
        return cnt<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=0;
        int high=0;
        int ans=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,weights[i]);
            high+=weights[i];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(weights,days,mid)){
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