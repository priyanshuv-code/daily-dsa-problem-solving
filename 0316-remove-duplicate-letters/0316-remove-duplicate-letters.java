class Solution {
    public String removeDuplicateLetters(String s) {
        
        int n = s.length();
        
        // Step 1: Store last occurrence index of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        // Step 2: Seen array
        boolean[] seen = new boolean[26];
        
        // Step 3: Stack
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            
            char ch = s.charAt(i);
            int curr = ch - 'a';
            
            // If already in stack, skip
            if (seen[curr]) continue;
            
            // Maintain lexicographically smallest order
            while (!stack.isEmpty() &&
                   stack.peek() > ch &&
                   i < lastIndex[stack.peek() - 'a']) {
                
                seen[stack.peek() - 'a'] = false;
                stack.pop();
            }
            
            stack.push(ch);
            seen[curr] = true;
        }
        
        // Build answer
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        
        // Reverse because stack pops in reverse order
        return ans.reverse().toString();
    }
}
