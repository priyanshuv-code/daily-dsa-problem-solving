class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char []ch=strs[i].toCharArray();
            Arrays.sort(ch);
            String st=new String(ch);

            if(map.containsKey(st)){
                map.get(st).add(strs[i]);
            }
            else{
                map.put(st,new ArrayList<>());
                map.get(st).add(strs[i]);
            }
        }
        for(HashMap.Entry<String,List<String>> s:map.entrySet()){
            ans.add(s.getValue());
        }
        return ans;
    }
}