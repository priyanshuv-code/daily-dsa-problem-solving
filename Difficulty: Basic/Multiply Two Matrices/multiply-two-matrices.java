class Solution {
    public ArrayList<ArrayList<Integer>> multiplyMatrices(int[][] a, int[][] b) {

        int m = a.length;
        int n = a[0].length;
        int p = b[0].length;

        ArrayList<ArrayList<Integer>> sum = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            sum.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {

                int val = 0;

                for (int k = 0; k < n; k++) {
                    val += a[i][k] * b[k][j];
                }

                sum.get(i).add(val);
            }
        }

        return sum;
    }
}