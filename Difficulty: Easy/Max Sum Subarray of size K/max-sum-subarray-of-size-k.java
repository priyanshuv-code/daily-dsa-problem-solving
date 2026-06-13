class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n=arr.length;
        int i=0;
        int max=0;
        int sum=0;
        for(int j=0;j<n;j++){
            sum+=arr[j];
            if(j-i+1<k){
                continue;
            }
            if(j-i+1==k){
                max=Math.max(max,sum);
                sum-=arr[i];
                i++;
            }
        }
        return max;
    }
}