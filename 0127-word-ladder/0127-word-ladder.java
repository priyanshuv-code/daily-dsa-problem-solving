class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        int level = 0;

        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();

            for (int i = 0; i < curLevelSize; i++) {
                String node = queue.poll();

                if (node.equals(endWord)) {
                    return level + 1;
                }

                List<String> neighbours = getNeighbours(node, set);

                for (String word : neighbours) {
                    if (set.contains(word)) {
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }
            level++;
        }

        return 0;
    }

    private List<String> getNeighbours(String word, HashSet<String> set) {
        List<String> neighbours = new ArrayList<>();
        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char original = arr[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                arr[i] = ch;
                String newWord = new String(arr);

                if (set.contains(newWord)) {
                    neighbours.add(newWord);
                }
            }

            arr[i] = original;
        }

        return neighbours;
    }
}