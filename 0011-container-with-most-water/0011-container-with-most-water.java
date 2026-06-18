class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int max=Integer.MIN_VALUE;
        int i=0;
        int j=n-1;
        while(i<j){
            int len=j-i;
            int hei=Math.min(height[i],height[j]);
            max=Math.max(max,hei*len);
            if( height[j]< height[i]){
                j--;
            }
            else{
                i++;
            }
        }
        return max;
    }   
}