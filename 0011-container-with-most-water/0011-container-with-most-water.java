class Solution {
    public int maxArea(int[] height) {
       int n=height.length;
       int low=0;
       int high=n-1;
       int ans=0;
       while(low<=high){
        int min=Math.min(height[low],height[high]);
        int len=high-low;
        if(height[low]<=height[high]){
            low++;
        }
        else{
            high--;
        }
        ans=Math.max(min*len,ans);
       }
       return ans;
    }
}