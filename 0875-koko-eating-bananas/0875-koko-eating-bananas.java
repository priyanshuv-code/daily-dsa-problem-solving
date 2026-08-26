class Solution {
    public boolean isPossible(int [] piles,int mid,int h){
        long cnt=0;
        for(int i=0;i<piles.length;i++){
            cnt+=(piles[i]+mid-1)/mid;
        }
        return cnt<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int start=1;
        int end=0;
        int ans=0;
        for(int arr:piles)end=Math.max(arr,end);
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPossible(piles,mid,h)){
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