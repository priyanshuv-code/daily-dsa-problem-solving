class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> t_map=new HashMap<>();
        // frequency of t...
        for(int j=0;j<t.length();j++){
            char ch=t.charAt(j);
            if(t_map.containsKey(ch)){
               t_map.put(ch,t_map.get(ch)+1);
            }
            else{
                t_map.put(ch,1);
            }
        }
        int min=Integer.MAX_VALUE;
        int t_count=t.length();
        int i=0;
        int j=0;
        int start=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(t_map.containsKey(ch)){
                if (t_map.get(ch) > 0) t_count--; 
                t_map.put(ch,t_map.get(ch)-1);
            }
            while(t_count==0){
                if(j-i+1<min){
                    min=j-i+1;
                    start=i;
                }

                char left=s.charAt(i);
                if(t_map.containsKey(left)){
                    t_map.put(left,t_map.get(left)+1);
                    if (t_map.get(left) > 0) t_count++;
                }
                i++;
            }
            j++;
        }
        if(min==Integer.MAX_VALUE){
            return "";
        }
        else{
            return s.substring(start,start+min); 
        }

    }
}