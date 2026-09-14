class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }
    }
    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } 
        else if (val > pq.peek()) {
            pq.add(val);
            pq.poll();
        }
        return pq.peek();
    }
}