import java.util.*;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // store frequency of nums4
        for (int num : nums4) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                for (int k = 0; k < nums3.length; k++) {

                    int sum = nums1[i] + nums2[j] + nums3[k];

                    if (map.containsKey(-sum)) {
                        count += map.get(-sum);
                    }

                }
            }
        }

        return count;
    }
}