class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int i=0;
        int j=n-1;
        int max=-1;
        while(i<j){
            if(height[i]<height[j]){
                int min=Math.min(height[i],height[j]);
                int area=min*(j-i);
                max=Math.max(max,area);
                i++;
            }
            else{
                int min=Math.min(height[i],height[j]);
                int area=min*(j-i);
                max=Math.max(max,area);
                j--;
            }
        }
        return max;
    }
}