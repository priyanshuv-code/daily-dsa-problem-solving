class Solution {

    class pair {
        long dist;
        int node;

        pair(long dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new pair(wt, v));
            adj.get(v).add(new pair(wt, u));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        pq.add(new pair(0, 0));

        while (!pq.isEmpty()) {

            pair curr = pq.poll();
            long currDist = curr.dist;
            int node = curr.node;

            for (pair it : adj.get(node)) {

                int adjNode = it.node;
                long edgeWt = it.dist;

                // shorter path
                if (currDist + edgeWt < dist[adjNode]) {
                    dist[adjNode] = currDist + edgeWt;
                    pq.add(new pair(dist[adjNode], adjNode));

                    ways[adjNode] = ways[node];
                }

                // equal shortest path
                else if (currDist + edgeWt == dist[adjNode]) {
                    ways[adjNode] += ways[node];
                }
            }
        }

        return (int) ways[n - 1]; 
    }
}