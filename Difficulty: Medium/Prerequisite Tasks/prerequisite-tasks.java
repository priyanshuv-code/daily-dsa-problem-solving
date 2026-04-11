// User function Template for Java

class Solution {
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        // Your Code goes here
        // Step 1: Create graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < N; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] it : prerequisites){
            adj.get(it[1]).add(it[0]); // v -> u
        }
        
        // Step 2: Compute indegree
        int[] indegree = new int[N];
        for(int i = 0; i < N; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        // Step 3: Push nodes with indegree 0
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        // Step 4: BFS (Kahn’s Algorithm)
        int count = 0;
        
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        // Step 5: Check
        return count == N;
    }
}