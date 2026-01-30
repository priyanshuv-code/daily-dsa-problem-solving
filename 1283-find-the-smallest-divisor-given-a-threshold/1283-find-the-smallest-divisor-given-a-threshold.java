class Solution {
    private int sumByDivisor(int [] nums,int mid){
        int sum=0;
        for(int num:nums){
            sum+=(num+mid-1)/mid; //ceil(numdivisor)
        }
        return sum;
    }



    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=0;

        // find max value
        for(int num:nums){
            high=Math.max(high,num);

        }

        // binary seach
        int ans=high;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            if(sumByDivisor(nums,mid)<=threshold){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
        
    }
}