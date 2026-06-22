class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return Atmost(nums,k)-Atmost(nums,k-1);
    }
    private int Atmost(int [] nums,int k){
        int n=nums.length;
        int count=0;
        int i=0;
        int j=0;
        int ans=0;
        while(j<n){
            if(nums[j]%2!=0)count++;

            while(count>k){
                if(nums[i]%2!=0)count--;
                i++;
            }
            ans+=j-i+1;
            j++;
        }
        return ans;
    }
}