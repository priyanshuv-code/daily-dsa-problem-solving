class Solution {
    public int countZeros(int[][] mat) {
        // code here
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        int m=mat.length;
        int n=mat[0].length;
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0)cnt++;
            }
        }
        return cnt;
    }
}