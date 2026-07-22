class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        StringBuilder ans=new StringBuilder();

        for(int i=0;i<numRows;i++){
            int idx=i;
            int changesouth=2*(numRows-1-i);
            int changenorth=2*i;
            boolean goingsouth=true;
            while(idx<s.length()){
                ans.append(s.charAt(idx));

                if(i==0){
                    idx+=changesouth;
                }
                else if(i==numRows-1){
                    idx+=changenorth;
                }
                else{
                    if(goingsouth){
                        idx+=changesouth;
                    }
                    else{
                        idx+=changenorth;
                    }
                    goingsouth=!goingsouth;

                }
            }
        }
        return ans.toString();
    }
}