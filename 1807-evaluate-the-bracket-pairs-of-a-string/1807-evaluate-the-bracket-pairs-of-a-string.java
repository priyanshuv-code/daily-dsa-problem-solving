class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        HashMap<String, String> map = new HashMap<>();

        // Store knowledge
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                i++; // move inside bracket

                StringBuilder key = new StringBuilder();

                while (s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }

                String k = key.toString();

                if (map.containsKey(k)) {
                    ans.append(map.get(k));
                } else {
                    ans.append("?");
                }

            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}