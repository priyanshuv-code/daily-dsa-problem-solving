class Solution {
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int [] vis,Stack<Integer> st){
        vis[node]=1;
        
        for(int it:adj.get(node)){
            if(vis[it]==0){
                dfs(it,adj,vis,st);
            }
        }
        // push after visiting all neighbors
        st.push(node);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []edge:edges){
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
        }
        
        int [] vis=new int[V];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,adj,vis,st);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
}