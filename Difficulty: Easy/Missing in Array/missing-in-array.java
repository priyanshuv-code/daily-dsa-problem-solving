class Solution {
    int missingNum(int nums[]) {
        int n = nums.length + 1;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }

        return sum;
    }
}