class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int max=0;
        while(j<n){
            char ch=s.charAt(j);

            if(!map.containsKey(ch)){
                map.put(ch,1);
            }
            else{
                map.put(ch,map.get(ch)+1);
            }

            if(map.get(ch)==1){
                max = Math.max(max, j - i + 1);
            }
            else{
                while(map.get(ch)>1){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i))==0)map.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        } 
        return max;
        
    }
}