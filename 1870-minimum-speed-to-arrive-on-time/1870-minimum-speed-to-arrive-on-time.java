class Solution {
    public boolean ispossible(int [] dist,int mid,double hour){
        double cnt=0;
        for(int i=0;i<dist.length-1;i++){
            cnt += Math.ceil((double) dist[i] / mid);
        }
        cnt+=(double) dist[dist.length - 1] / mid;
        return cnt<=hour;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int n=dist.length;
        int start=1;
        int end = 10000000;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(ispossible(dist,mid,hour)){
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