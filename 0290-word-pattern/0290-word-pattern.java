import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] arr = s.split(" ");

        if (pattern.length() != arr.length) {
            return false;
        }

        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = arr[i];

            // Both mappings already exist
            if (map1.containsKey(ch) && map2.containsKey(word)) {

                if (!map1.get(ch).equals(word) || map2.get(word) != ch) {
                    return false;
                }

            }
            // Neither mapping exists
            else if (!map1.containsKey(ch) && !map2.containsKey(word)) {

                map1.put(ch, word);
                map2.put(word, ch);

            }
            // One exists, the other doesn't
            else {

                return false;

            }
        }

        return true;
    }
}