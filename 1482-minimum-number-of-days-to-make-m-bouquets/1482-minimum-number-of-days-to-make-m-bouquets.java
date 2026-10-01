class Solution {
    public static boolean ispossible(int[] bloomDay,int mid,int m,int k){
        int cnt=0;
        int c=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                c++;
                if(c==k){
                    cnt++;
                    c=0;
                }
            }
            else{
                c=0;
            }
        }
        return cnt>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        int ans=-1;
        for(int i=0;i<bloomDay.length;i++){
            start=Math.min(start,bloomDay[i]);
            end=Math.max(end,bloomDay[i]);
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if(ispossible(bloomDay,mid,m,k)){
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