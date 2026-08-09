class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       ArrayList<Integer> ans=new ArrayList<>();
       int m=matrix.length;
       int n=matrix[0].length;
       int top=0;
       int left=0;
       int bottom=m-1;
       int right=n-1;
       int total=0;
       while(total<m*n){
        for(int i=left;i<=right && total<m*n;i++){
            ans.add(matrix[top][i]);
            total++;
        }
        top++;
        for(int i=top;i<=bottom && total<m*n;i++){
            ans.add(matrix[i][right]);
            total++;
        }
        right--;
        for(int i=right;i>=left && total<m*n;i--){
            ans.add(matrix[bottom][i]);
            total++;
        }
        bottom--;
        for(int i=bottom;i>=top && total<m*n;i--){
            ans.add(matrix[i][left]);
            total++;
        }
        left++;
       }
       return ans;
    }
}