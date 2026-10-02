class Solution {
    public static boolean ispossible(int [] pos,long mid,int m){
        int last=pos[0];
        int cnt=1;
        for(int i=1;i<pos.length;i++){
            if(pos[i]-last>=mid){
                cnt++;
                last=pos[i];
            }
        }
        return cnt>=m;
    }
    public int maxDistance(int[] pos, int m) {
        int n=pos.length;
        Arrays.sort(pos);
        int start=0;
        int end=pos[n-1]-pos[0];
        long ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;;
            if(ispossible(pos,mid,m)){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return (int)ans;
    }
}