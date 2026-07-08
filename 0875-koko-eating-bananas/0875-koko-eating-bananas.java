class Solution {
    public boolean checkeating(int []piles,int k,int h){
        long cnt=0;
        for(int i=0;i<piles.length;i++){
            cnt+=(piles[i]+k-1)/k;
        }
        if(cnt<=h){
            return true;
        }
        else{
            return false;
        }
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=1;
        int high=0;
        for(int i=0;i<n;i++){
            low=Math.min(low,piles[i]);
            high=Math.max(high,piles[i]);
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            boolean caneat=checkeating(piles,mid,h);

            if(caneat==true){
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