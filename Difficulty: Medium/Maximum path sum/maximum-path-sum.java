class Solution {
    int maxValue = Integer.MIN_VALUE;

    int findMaxSum(Node root) {
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(Node node) {
        if (node == null) return 0;

        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));

        maxValue = Math.max(maxValue, left + right + node.data);

        return Math.max(left, right) + node.data;
    }
}
