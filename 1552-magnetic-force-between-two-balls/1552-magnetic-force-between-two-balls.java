class Solution {
    private boolean ispossible(int mid,int []  position,int m){
        int cnt=1;
        int last= position[0];
        for(int i=1;i< position.length;i++){
            if( position[i]-last>=mid){
                cnt++;
                last=position[i];
            }
        }
        return cnt>=m;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort( position);
        int low=1;
        int high= position[ position.length-1]-  position[0];

        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(ispossible(mid, position,m)){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}