class Solution {

    class Node {
        int city, cost, stops;
        Node(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int CheapestFLight(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src, 0, 0));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.stops > k) continue;

            for (int[] it : adj.get(cur.city)) {
                int next = it[0];
                int price = it[1];

                if (cur.cost + price < dist[next]) {
                    dist[next] = cur.cost + price;
                    q.add(new Node(next, dist[next], cur.stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
