class Solution {
    public boolean canFinish(int N, int[][] prerequisites) {
        // code here
         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }

        for(int []it:prerequisites){
            adj.get(it[1]).add(it[0]);
        }

        int []indegree=new int[N];
        for(int i=0;i<N;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;

        while(!q.isEmpty()){
            int node=q.poll();
            count++;

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(count==N)return true;
        return false;
    }
}
