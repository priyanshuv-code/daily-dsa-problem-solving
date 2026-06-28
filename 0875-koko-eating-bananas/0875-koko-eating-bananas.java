class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=0;
        int high=0;
        int ans=0;

        for(int i=0;i<n;i++){
            high=Math.max(high,piles[i]);
            low+=piles[i];
        }
        low=low/h;

        while(low<=high){
            int mid=low+(high-low)/2;

            long cnt=0;
            for(int i=0;i<n;i++){
                cnt+=(int)Math.ceil((double) piles[i]/mid);
            }
            if(cnt<=h){
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