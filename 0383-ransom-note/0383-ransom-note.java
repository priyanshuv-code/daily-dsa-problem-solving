class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int r_len=ransomNote.length();
        int m_len=magazine.length();
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();

        for(int i=0;i<r_len;i++){
            char ch=ransomNote.charAt(i);
            if(map1.containsKey(ch)){
                map1.put(ch,map1.get(ch)+1);
            }
            else{
                map1.put(ch,1);
            }
        }

        for(int i=0;i<m_len;i++){
            char ch= magazine.charAt(i);
            if(map2.containsKey(ch)){
                map2.put(ch,map2.get(ch)+1);
            }
            else{
                map2.put(ch,1);
            }
        }

        for(int i=0;i<r_len;i++){
            if (!map2.containsKey(ransomNote.charAt(i))) {
                return false;
            }
            if(map1.get(ransomNote.charAt(i))>map2.get(ransomNote.charAt(i))){
                return false;
            }
        }
        return true;
    }
}