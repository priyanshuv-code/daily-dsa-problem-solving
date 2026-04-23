class Solution {
    class pair{
        int effort;
        int row;
        int col;
        pair(int effort,int row,int col){
            this.effort=effort;
            this.row=row;
            this.col=col;
        }
    }
    public int minCostPath(int[][] height) {
        int n=height.length;
        int m=height[0].length;

        int [][]dist=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],(int)1e9);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.add(new pair(0,0,0));
        dist[0][0]=0;

        int []dr={0,1,0,-1};
        int []dc={1,0,-1,0};
        while(!pq.isEmpty()){
            pair curr=pq.poll();
            int effort=curr.effort;
            int row=curr.row;
            int col=curr.col;

            if(row==n-1 && col==m-1) return effort;

            for(int i=0;i<4;i++){
                int newrow=row+dr[i];
                int newcol=col+dc[i];

                if(newrow>=0 && newrow<n && newcol>=0 && newcol<m){
                    int newEffort = Math.max(
                        effort,
                        Math.abs(height[row][col] - height[newrow][newcol])
                    );
                    if(newEffort<dist[newrow][newcol]){
                        dist[newrow][newcol]=newEffort;
                        pq.add(new pair(newEffort, newrow, newcol));
                    }
                }
            }
        }
        return -1;
    }
}
