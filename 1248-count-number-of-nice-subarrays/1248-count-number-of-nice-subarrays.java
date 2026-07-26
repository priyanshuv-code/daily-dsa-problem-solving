class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return goal(nums,k)-goal(nums,k-1);
    }
    public static int goal(int []nums,int k){
        int oddcnt=0;
        int i=0;
        int j=0;
        int cnt=0;
        while(j<nums.length){
            if(nums[j]%2!=0)oddcnt++;

            while(oddcnt>k){
                if(nums[i]%2!=0)oddcnt--;
                i++;
            }
           cnt+=j-i+1; 
           j++;
        }
        return cnt;
    }
}