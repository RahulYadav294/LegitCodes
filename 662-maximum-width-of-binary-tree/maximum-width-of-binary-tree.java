/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Pair {
        TreeNode node;
        long pos;

        Pair(TreeNode nde, long pos) {
            this.node = nde;
            this.pos = pos;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            long leftMost = q.peek().pos;
            long rightMost = leftMost;

            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();

                TreeNode node = curr.node;
                long pos = curr.pos;

                rightMost = pos;

                if (node.left != null) {
                    q.offer(new Pair(
                        node.left,
                        2 * pos + 1
                    ));
                }

                if (node.right != null) {
                    q.offer(new Pair(
                        node.right,
                        2 * pos + 2
                    ));
                }
            }

            int width = (int)(rightMost - leftMost + 1);

            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}