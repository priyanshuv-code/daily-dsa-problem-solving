class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] result = new int[n];
        
        // Step 1: Build prefix sum array
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        
        // Step 2: Calculate result using formula
        for (int i = 0; i < n; i++) {
            
            // Left part
            int left = nums[i] * i - (prefix[i] - nums[i]);
            
            // Right part
            int right = (prefix[n - 1] - prefix[i]) 
                        - nums[i] * (n - i - 1);
            
            result[i] = left + right;
        }
        
        return result;
    }
}