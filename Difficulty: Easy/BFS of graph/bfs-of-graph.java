class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int V=adj.size();
        boolean[] visted=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        
        q.add(0);
        visted[0]=true;
        
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int n:adj.get(node)){
                if(!visted[n]){
                    visted[n]=true;
                    q.add(n);
                }
            }
        }
        return ans;
    }
}