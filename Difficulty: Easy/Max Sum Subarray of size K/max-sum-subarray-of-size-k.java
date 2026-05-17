class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n=arr.length;
        int sum=0;
        int max=Integer.MIN_VALUE;
        int i=0;
        int j=0;
        
        while(j<n){
            sum+=arr[j];
            
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                max=Math.max(sum,max);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return max;
        
    }
}