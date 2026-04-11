class Solution {
    public ArrayList<Integer> findOrder(int N, int[][] prerequisites) {
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
        ArrayList<Integer> topo=new ArrayList<>();
        

        while(!q.isEmpty()){
            int node=q.poll();
            topo.add(node);

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(topo.size()==N)return topo;
        return new ArrayList<>();  
    }
}
