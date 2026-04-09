class Solution {
    
    private boolean ispossible(int[] arr, int mid, int k){
        int student = 1;
        int pages = 0;

        for(int i = 0; i < arr.length; i++){
            if(pages + arr[i] <= mid){
                pages += arr[i];
            } else {
                student++;
                pages = arr[i];
            }
        }

        return student <= k;
    }

    public int findPages(int[] arr, int k) {
        if(k > arr.length) return -1;

        int low = 0, high = 0;

        for(int i = 0; i < arr.length; i++){
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(ispossible(arr, mid, k)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}