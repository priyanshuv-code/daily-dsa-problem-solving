class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int max=0;
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
            if(map.get(ch)==1){
                max=Math.max(max,j-i+1);
            }
            else{
                while(map.get(ch)>1){
                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
                    if(map.get(s.charAt(i))==0) map.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}