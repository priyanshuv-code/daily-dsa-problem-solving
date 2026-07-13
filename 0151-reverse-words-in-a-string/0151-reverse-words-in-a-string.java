class Solution {
    public String reverseWords(String s) {
        String [] word=s.split(" ");

        int l=0;
        int r=word.length-1;

        while(l<r){
            String temp=word[l];
            word[l]=word[r];
            word[r]=temp;
            l++;
            r--;
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<word.length;i++){
            if(word[i]!=("")){
                if(ans.length()>0){
                    ans.append(" ");
                }
                ans.append(word[i]);
            }
        }
        return ans.toString();
    }
}