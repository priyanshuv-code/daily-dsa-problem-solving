class Solution {
    public int lengthOfLastWord(String s) {
        String t=s.trim();

        String []arr=t.split(" ");

        return arr[arr.length-1].length();
        
    }
}