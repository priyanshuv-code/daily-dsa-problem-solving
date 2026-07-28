class Solution {
    public boolean isPossible(int []piles,int h,int k){
        long cnt=0;
        for(int i=0;i<piles.length;i++){
            cnt+=(piles[i]+k-1)/k;
        }
        return cnt<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=1;
        int high=0;
        for(int i=0;i<n;i++){
            high=Math.max(high,piles[i]);
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(piles,h,mid)){
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