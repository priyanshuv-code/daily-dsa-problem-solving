class Solution {
    public int[] findOrder(int N, int[][] prerequisites) {
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
        int [] topo=new int[N];
        int idx=0;

        while(!q.isEmpty()){
            int node=q.poll();
            topo[idx++]=node;

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(topo.length==N)return topo;
        return new int[0];
    }
}