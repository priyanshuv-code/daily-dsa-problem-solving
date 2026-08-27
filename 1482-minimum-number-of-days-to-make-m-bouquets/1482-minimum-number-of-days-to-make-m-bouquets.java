class Solution {
    public boolean isPossible(int []bloomDay,int mid,int m,int k){
        int c=0;
        int cnt=0;
        for(int i=0;i<bloomDay.length;i++){
            if(c==k){
                cnt++;
                c=0;
            }
            if(mid>=bloomDay[i]){
                c++;
            }
            else{
                c=0;
            }
        }
        if (c == k) {
            cnt++;
        }
        return cnt>=m;
        
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;
        int ans=-1;
        for(int i=0;i<n;i++){
            start=Math.min(start,bloomDay[i]);
            end=Math.max(end,bloomDay[i]);
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPossible(bloomDay,mid,m,k)){
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