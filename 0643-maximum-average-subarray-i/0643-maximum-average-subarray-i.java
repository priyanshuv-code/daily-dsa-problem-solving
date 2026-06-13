class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = Double.NEGATIVE_INFINITY;
        int n=nums.length;
        int i=0;
        double sum=0;
        for(int j=0;j<n;j++){
            sum+=nums[j];
            if(j-i+1<k){
                continue;
            }
            if(j-i+1==k){
                max=Math.max(max,sum);
                sum-=nums[i];
                i++;
            }
        }
        return max/k;
    }
}