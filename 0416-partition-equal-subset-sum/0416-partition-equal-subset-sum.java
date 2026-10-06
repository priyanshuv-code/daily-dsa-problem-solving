class Solution {

    public boolean solve(int idx, int target, Boolean[][] dp, int[] nums) {

        if (target == 0) return true;

        if (idx == 0) return nums[0] == target;

        if (dp[idx][target] != null) {
            return dp[idx][target];
        }

        // not take
        boolean not_take = solve(idx - 1, target, dp, nums);

        // take
        boolean take = false;

        if (nums[idx] <= target) {
            take = solve(idx - 1, target - nums[idx], dp, nums);
        }

        return dp[idx][target] = take || not_take;
    }

    public boolean canPartition(int[] nums) {

        int n = nums.length;

        int target = 0;

        for (int i = 0; i < n; i++) {
            target += nums[i];
        }

        if (target % 2 != 0) return false;

        target = target / 2;

        Boolean[][] dp = new Boolean[n][target + 1];

        return solve(n - 1, target, dp, nums);
    }
}