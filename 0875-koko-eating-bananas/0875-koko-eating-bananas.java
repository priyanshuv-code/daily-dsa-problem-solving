class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;

        for(int num:piles){
            high=Math.max(high,num);
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            long totalhours=0;
            for(int i=0;i<piles.length;i++){
                totalhours+=(piles[i]+mid-1)/mid;
            }

            if(totalhours<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}