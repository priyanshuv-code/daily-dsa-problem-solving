class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> wraplist = new LinkedList<>();
        if (root == null) return wraplist;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelNo = queue.size();
            List<Integer> sublist = new LinkedList<>();

            for (int i = 0; i < levelNo; i++) {
                TreeNode curr = queue.poll();

                sublist.add(curr.val);

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            wraplist.add(sublist);
        }

        return wraplist;
    }
}
