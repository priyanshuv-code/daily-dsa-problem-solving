class Solution {
    public int maxVowels(String s, int k) {
        int n=s.length();
        int i=0;
        int max=-1;
        int count=0;
        for(int j=0;j<n;j++){
            if(isVowel(s.charAt(j))){
                count++;
            }
            if(j-i+1==k){
                max=Math.max(max,count);

                if(isVowel(s.charAt(i))){
                    count--;
                }
                i++;
            }
        }       
        return max;
    }
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}