import java.util.*;

class Solution {

    public int minJumps(int[] nums) {

        int n = nums.length;

        if (n == 1) return 0;

        int maxVal = 0;
        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        // Smallest Prime Factor sieve
        int[] spf = buildSPF(maxVal);

        // prime -> indices divisible by prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int val = nums[i];
            Set<Integer> factors = new HashSet<>();

            while (val > 1) {
                int p = spf[val];
                factors.add(p);

                while (val % p == 0) {
                    val /= p;
                }
            }

            for (int p : factors) {
                map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1) {
                    return steps;
                }

                // left
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // right
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                // teleport only if nums[idx] is prime
                int val = nums[idx];

                if (val > 1 && spf[val] == val) {

                    List<Integer> nexts = map.getOrDefault(val, new ArrayList<>());

                    for (int next : nexts) {

                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(next);
                        }
                    }

                    // important optimization
                    map.remove(val);
                }
            }

            steps++;
        }

        return -1;
    }

    // Smallest Prime Factor Sieve
    private int[] buildSPF(int n) {

        int[] spf = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= n; i++) {

            if (spf[i] == i) {

                for (int j = i * i; j <= n; j += i) {

                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        return spf;
    }
}