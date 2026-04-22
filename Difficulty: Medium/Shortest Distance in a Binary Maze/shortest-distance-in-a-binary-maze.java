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

    public int shortestPath(int[][] grid, int[] source, int[] destination) {

        int n = grid.length;
        int m = grid[0].length;

        // Edge case
        if (source[0] == destination[0] && source[1] == destination[1])
            return 0;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int)1e9);
        }

        Queue<Pair> q = new LinkedList<>();

        dist[source[0]][source[1]] = 0;
        q.add(new Pair(0, source[0], source[1]));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Pair cur = q.poll();
            int d = cur.dist;
            int r = cur.row;
            int c = cur.col;

            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                if (newr >= 0 && newr < n && newc >= 0 && newc < m
                        && grid[newr][newc] == 1
                        && d + 1 < dist[newr][newc]) {

                    dist[newr][newc] = d + 1;

                    // Early exit
                    if (newr == destination[0] && newc == destination[1]) {
                        return d + 1;
                    }

                    q.add(new Pair(d + 1, newr, newc));
                }
            }
        }

        return -1; // Not reachable
    }
}