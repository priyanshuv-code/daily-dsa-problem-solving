class Solution {
    private boolean ispossible(int [] stalls ,int mid,int k){
        int cnt=1;
        int last=stalls[0];
        
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last>=mid){
                cnt++;
                last=stalls[i];
            }
        }
        return cnt>=k;
    }
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int low=1;
        int high=stalls[stalls.length-1]-stalls[0];
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(ispossible(stalls,mid,k)){
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