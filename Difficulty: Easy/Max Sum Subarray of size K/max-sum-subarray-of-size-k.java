class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int max=Integer.MIN_VALUE;
        int i=0;
        int sum=0;

        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            
            
            if(j-i+1==k){
                max=Math.max(max,sum);
                sum-=arr[i];
                i++;
            }
        }
        return max;
    }
}