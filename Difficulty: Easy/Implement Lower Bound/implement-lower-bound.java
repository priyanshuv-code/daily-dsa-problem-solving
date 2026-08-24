class Solution {
    int lowerBound(int[] arr, int target) {
        // code here
        int n=arr.length;
        int start=0;
        int end=n;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>=target)end=mid;
            else start=mid+1;
        }
        return start;
    }
}
