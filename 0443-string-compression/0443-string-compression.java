class Solution {
    public int compress(char[] chars) {
        int index=0;
        int i=0;
        while(i<chars.length){
            int cnt=0;
            char ch=chars[i];

            while(i<chars.length && chars[i]==ch){
                cnt++;
                i++;
            }
            chars[index]=ch;
            index++;

            if(cnt>1){
                String str=Integer.toString(cnt);
                for(char c:str.toCharArray()){
                    chars[index]=c;
                    index++;
                }
            }
        }
        return index;
    }
}