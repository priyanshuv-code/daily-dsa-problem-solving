// User function Template for Java

class Solution {
    
    private void dfs(int row,int col,int [][]vis,int[][] grid,ArrayList<String> list,int baserow,int basecol){
        vis[row][col]=1;
        list.add((row - baserow) + "," + (col - basecol));
        int n=grid.length;
        int m=grid[0].length;
        
        int []delrow={-1,0,1,0};
        int []delcol={0,1,0,-1};
        
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,vis,grid,list,baserow,basecol);
            }
        }
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n=grid.length;
        int m=grid[0].length;
        int [][]vis=new int [n][m];
        
        HashSet<ArrayList<String>> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    ArrayList<String> list=new ArrayList<>();
                    dfs(i,j,vis,grid,list,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}
