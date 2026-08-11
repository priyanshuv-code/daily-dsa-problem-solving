class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int totalsum=0;
        int minsub=Integer.MAX_VALUE;
        int maxsub=Integer.MIN_VALUE;
        int minsum=0;
        int maxsum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
           totalsum+=arr[i];
            minsum+=arr[i];
            maxsum+=arr[i];
            minsub=Math.min(minsum,minsub);
            maxsub=Math.max(maxsum,maxsub);
            if(minsum>0)minsum=0;
            if(maxsum<0)maxsum=0;
        }
        if(maxsub < 0)return maxsub;
        return Math.max(maxsub,totalsum-minsub);
    }
}