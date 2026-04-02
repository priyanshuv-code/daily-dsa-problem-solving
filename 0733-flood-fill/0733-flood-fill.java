class Solution {

    int rows;
    int cols;

    void dfs(int row, int col, int newColor, int curColor, boolean[][] visited, int[][] image) {

        // out of bounds, already visited, or color not same
        if (row < 0 || row >= rows || col < 0 || col >= cols 
            || image[row][col] != curColor || visited[row][col]) {
            return;
        }

        // mark color and visited
        image[row][col] = newColor;
        visited[row][col] = true;

        // directions: up, right, down, left
        int[][] adjList = {
            {row - 1, col},
            {row, col + 1},
            {row + 1, col},
            {row, col - 1}
        };

        for (int[] neighbour : adjList) {
            dfs(neighbour[0], neighbour[1], newColor, curColor, visited, image);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int curColor = image[sr][sc];

        dfs(sr, sc, color, curColor, visited, image);

        return image;
    }
}