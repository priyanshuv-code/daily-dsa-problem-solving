class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int multi=1;
        int i=0;
        int j=0;
        int cnt=0;
        if(k<=1)return 0;
        while(j<nums.length){
            multi*=nums[j];

            while(multi>=k){
                multi=multi/nums[i];
                i++;
            }
            cnt+=j-i+1;
            j++;
        }
        return cnt;
    }
}