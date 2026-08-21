class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<p.length();i++){
            map1.put(p.charAt(i),map1.getOrDefault(p.charAt(i),0)+1);
        }
        HashMap<Character,Integer> map2=new HashMap<>();
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            if(j-i+1>p.length()){
                char remove=s.charAt(i);
                map2.put(remove, map2.getOrDefault(remove, 0)-1);
                if(map2.get(remove)==0)map2.remove(remove);
                i++;
            }
            if(j-i+1==p.length()){
                if(map1.equals(map2)){
                    ans.add(i);
                }
            }
            j++;
        }
        return ans;
    }
}