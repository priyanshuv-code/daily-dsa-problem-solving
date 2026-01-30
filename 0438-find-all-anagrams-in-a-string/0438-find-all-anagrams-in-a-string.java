class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;

        // Step 1: frequency of p
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            if (pMap.containsKey(ch)) {
                pMap.put(ch, pMap.get(ch) + 1);
            } else {
                pMap.put(ch, 1);
            }
        }

        // Step 2: sliding window
        HashMap<Character, Integer> sMap = new HashMap<>();
        int window = p.length();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // add character to window
            if (sMap.containsKey(ch)) {
                sMap.put(ch, sMap.get(ch) + 1);
            } else {
                sMap.put(ch, 1);
            }

            // remove character out of window
            if (i >= window) {
                char toRemove = s.charAt(i - window);
                if (sMap.get(toRemove) == 1) {
                    sMap.remove(toRemove);
                } else {
                    sMap.put(toRemove, sMap.get(toRemove) - 1);
                }
            }

            // compare both maps
            if (sMap.equals(pMap)) {
                ans.add(i - window + 1);
            }
        }

        return ans;
    }
}
