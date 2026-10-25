
class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if (n == 1) return stones[0];

        if (n == 2) {
            if (stones[0] == stones[1]) return 0;
            if (stones[0] > stones[1]) return stones[0] - stones[1];
            if (stones[1] > stones[0]) return stones[1] - stones[0];
        }

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int ele : stones) {
            pq.add(ele);
        }

        while (pq.size() > 1) {
            boolean b = false;
            int fir = pq.remove();
            int sec = pq.remove();

            if (fir == sec) {
                b = true;
            }

            if (!b) {
                pq.add(fir - sec);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
