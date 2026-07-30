class Solution {
    public String kthLargestNumber(String[] nums, int k) {

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length(); // smaller length = smaller number
            }
            return a.compareTo(b); // if same length, compare lexicographically
        });

        for (String num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll(); // remove smallest
            }
        }

        return pq.peek();
    }
}