class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n=name.length();
        int i=0;
        int j=0;
        while(i<n && j<typed.length()){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }
            else if((j > 0 && name.charAt(i-1)==typed.charAt(j))){
                j++;
            }
            
            else{
                return false;
            }
        }
        while (j < typed.length()) {
            if (typed.charAt(j) != typed.charAt(j - 1))
                return false;
            j++;
        }

        return i == name.length();
    }
}