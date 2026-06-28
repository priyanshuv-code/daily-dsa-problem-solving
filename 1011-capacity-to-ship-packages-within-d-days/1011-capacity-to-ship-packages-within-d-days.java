class Solution {
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

            int cnt=1;
            int sum=weights[0];
            for(int i=1;i<n;i++){
                sum+=weights[i];

                if(sum>mid){
                    sum=weights[i];
                    cnt++;
                }
            }
            if(cnt<=days){
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