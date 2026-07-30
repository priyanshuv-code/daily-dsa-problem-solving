class Triplet implements Comparable<Triplet> {
    int dist;
    int x;
    int y;

    Triplet(int dist, int x, int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Triplet p) {
        return this.dist - p.dist;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {

        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;

            pq.add(new Triplet(dist, x, y));

            if (pq.size() > k)
                pq.poll();
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            Triplet top = pq.poll();

            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(top.x);
            temp.add(top.y);

            ans.add(temp);
        }

        return ans;
    }
}