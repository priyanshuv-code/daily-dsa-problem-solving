class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;

        int []ans=new int[n];
        int i=0;
        int j=0;
        int max=0;
        while(j<nums.length){
            if(nums[j]==0) k--;

            while(k<0){
                if(nums[i]==0)k++;
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max; 
        
    }
}