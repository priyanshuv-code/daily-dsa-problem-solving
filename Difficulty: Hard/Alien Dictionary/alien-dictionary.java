class Solution {
    
    // 🔥 Topological Sort Function
    public List<Integer> topoSort(ArrayList<ArrayList<Integer>> adj, boolean[] present){
        
        int[] indegree = new int[26];
        
        // calculate indegree
        for(int i = 0; i < 26; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        // push nodes with indegree 0 and present
        for(int i = 0; i < 26; i++){
            if(present[i] && indegree[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer> topo = new ArrayList<>();
        
        // BFS
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        return topo;
    }
    
    
    // 🔥 Main Function
    public String findOrder(String[] words) {
        
        // Step 1: Graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            adj.add(new ArrayList<>());
        }
        
        // Step 2: Track present chars
        boolean[] present = new boolean[26];
        for(String word : words){
            for(char ch : word.toCharArray()){
                present[ch - 'a'] = true;
            }
        }
        
        // Step 3: Build graph
        for(int i = 0; i < words.length - 1; i++){
            String s1 = words[i];
            String s2 = words[i + 1];
            
            int len = Math.min(s1.length(), s2.length());
            boolean found = false;
            
            for(int j = 0; j < len; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get(s1.charAt(j) - 'a')
                       .add(s2.charAt(j) - 'a');
                    found = true;
                    break;
                }
            }
            
            // ⚠️ prefix edge case
            if(!found && s1.length() > s2.length()){
                return "";
            }
        }
        
        // Step 4: Topo Sort
        List<Integer> topo = topoSort(adj, present);
        
        // Step 5: Count present chars
        int count = 0;
        for(boolean b : present){
            if(b) count++;
        }
        
        // Step 6: Check cycle
        if(topo.size() != count) return "";
        
        // Step 7: Convert to string
        String ans = "";
        for(int it : topo){
            ans += (char)(it + 'a');
        }
        
        return ans;
    }
}