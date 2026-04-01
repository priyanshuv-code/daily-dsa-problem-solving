class Solution {
    private void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean [] vis,ArrayList<Integer> ls){
        vis[node]=true;
        ls.add(node);
        
        for(int it:adj.get(node)){
            if(!vis[it]){
                dfs(it,adj,vis,ls);
            }
        }
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V=adj.size();
        boolean [] vis=new boolean[V];
        ArrayList<Integer> ls=new ArrayList<>();
        int start=0;
        dfs(start,adj,vis,ls);
        return ls;
    }
}