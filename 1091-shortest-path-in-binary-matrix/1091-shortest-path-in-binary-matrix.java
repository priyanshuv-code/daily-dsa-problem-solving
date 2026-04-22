import java.util.*;

class Solution {

    static class Pair {
        int dist, row, col;

        Pair(int d, int r, int c) {
            dist = d;
            row = r;
            col = c;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // Edge case
        if (grid[0][0] == 1) return -1;

        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int)1e9);
        }

        Queue<Pair> q = new LinkedList<>();

        dist[0][0] = 1;
        q.add(new Pair(1, 0, 0));

        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        while (!q.isEmpty()) {

            Pair cur = q.poll();
            int d = cur.dist;
            int r = cur.row;
            int c = cur.col;

            // Destination reached
            if (r == n - 1 && c == n - 1) {
                return d;
            }

            for (int i = 0; i < 8; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < n
                        && grid[newr][newc] == 0
                        && d + 1 < dist[newr][newc]) {

                    dist[newr][newc] = d + 1;
                    q.add(new Pair(d + 1, newr, newc));
                }
            }
        }

        return -1;
    }
}