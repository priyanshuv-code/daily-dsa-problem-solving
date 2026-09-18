class Solution {
    public String minWindow(String s, String t) {
        int t1=t.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t1;i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int start=0;
        int min=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int cnt=t.length();
        int n=s.length();
        while(j<n){
            char ch =s.charAt(j);
            if(map.containsKey(ch)){
                if(map.get(ch)>0) cnt--;
                map.put(ch,map.get(ch)-1);
            }
            while(cnt==0){
                if(min>j-i+1){
                    min=j-i+1;
                    start=i;
                }
                char left=s.charAt(i); 
                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if(map.get(left)>0)
                    cnt++;
                }
                i++;
            }
            j++;
        }
       if(min==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+min);
    }
}