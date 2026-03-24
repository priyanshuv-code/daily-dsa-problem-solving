class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                map.put(
                    t.charAt(i),map.get(t.charAt(i))+1);
            }
            else{
                map.put(t.charAt(i),1);
            }
        }
        int i=0;
        int start=0;
        int n=s.length();
        int min=Integer.MAX_VALUE;
        int count=t.length();
        for(int j=0;j<n;j++){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                if (map.get(ch) > 0) count--;  // main
                map.put(ch, map.get(ch) - 1);
            }
            while(count==0){
                if(j-i+1<min){
                    min=j-i+1;
                    start=i;
                }
                char left=s.charAt(i);
                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if (map.get(left) > 0) { //main
                     count++;  
                    }   
                }
                i++;
            } 
        }
        if(min==Integer.MAX_VALUE){
            return "";
        }
        else{
            return s.substring(start,start+min); 
        }
    }
}