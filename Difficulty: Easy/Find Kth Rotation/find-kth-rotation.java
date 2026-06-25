class Solution {
    int findKRotation(int arr[]) {

        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Left half is sorted
            if (arr[low] <= arr[mid]) {

                if (arr[low] < ans) {
                    ans = arr[low];
                    index = low;
                }

                low = mid + 1;
            }
            // Right half is sorted
            else {

                if (arr[mid] < ans) {
                    ans = arr[mid];
                    index = mid;
                }

                high = mid - 1;
            }
        }

        return index;
    }
}