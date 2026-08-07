class Solution {
    public void addMat(int[][] a, int[][] b) {
        // code here
        int m=a.length;
        int n=a[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=a[i][j]+b[i][j];
            }
        }
    }
}