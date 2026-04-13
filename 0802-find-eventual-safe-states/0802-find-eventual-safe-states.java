class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            for(int it:graph[i]){
                adj.get(i).add(it);
            }
        }

        int [] indegree=new int[V];
        ArrayList<ArrayList<Integer>> rev=new ArrayList<>();
        for(int i=0;i<V;i++){
            rev.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                rev.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<V;i++){
            if(indegree[i]==0) q.add(i);
        }
        
        ArrayList<Integer> safe=new ArrayList<>();

        while(!q.isEmpty()){
            int node=q.poll();
            safe.add(node);

            for(int it:rev.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }
}