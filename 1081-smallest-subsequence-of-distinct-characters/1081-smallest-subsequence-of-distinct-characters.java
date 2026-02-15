class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];     // Step 1: frequency array
        boolean[] visited = new boolean[26]; // Step 2: visited array
        
        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            
            // decrease frequency
            freq[ch - 'a']--;
            
            // if already in stack, skip
            if (visited[ch - 'a']) continue;
            
            // maintain lexicographical order
            while (!stack.isEmpty() &&
                   stack.peek() > ch &&
                   freq[stack.peek() - 'a'] > 0) {
                
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            
            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        
        // build result
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        
        return result.toString();
    }
}
