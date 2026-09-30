class Solution {
    public boolean ispossible(int []piles,int k,int h){
        long cnt=0;
        for(int i=0;i<piles.length;i++){
            cnt+=(piles[i]+k-1)/k;
        }
        return cnt<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int start=1;
        int end=0;
        for(int a:piles)end=Math.max(end,a);
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(ispossible(piles,mid,h)){
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