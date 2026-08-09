class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        ArrayList<Integer> list=new ArrayList<>();
        int m=0;
        int n=0;
        for(int i=0;i<s.length();i++){
            m=Math.max(m,map.get(s.charAt(i)));
            if(i==m){
                list.add(m-n+1);
                n=i+1;
            }
        }
        return list;
    }
}