class Solution {
    public int findGCD(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=0;

        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int ans=0;
        for(int i=1;i<=max;i++){
            if(min%i==0 && max%i==0){
                ans=Math.max(ans,i);
            }
        }
        return ans;
    }
}