class Solution {
    public static char getMaxOccuringChar(String s) {
        // code here
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        char ans=s.charAt(0);
        int f=0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            int freq = map.get(ch);
            if(freq > f || (freq == f && ch < ans)){
                ans=s.charAt(i);
                f=map.get(s.charAt(i));
            }
        }
        return ans;
    }
    
}