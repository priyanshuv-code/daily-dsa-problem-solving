class Solution {
    public int findPages(int[] arr, int k) {

        int n = arr.length;

        if (k > n) return -1;

        int low = 0;
        int high = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int cnt = 1;
            int sum = arr[0];

            for (int i = 1; i < n; i++) {
                sum += arr[i];

                if (sum > mid) {
                    cnt++;
                    sum = arr[i];
                }
            }

            if (cnt <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}