class Solution {

    static StringBuilder sb;

    public static String reverseString(String s) {
        sb = new StringBuilder();
        reverse(s, s.length() - 1);
        return sb.toString();
    }

    public static void reverse(String s, int i){
        if(i < 0) return;
        sb.append(s.charAt(i));
        reverse(s, i - 1);
    }
}
