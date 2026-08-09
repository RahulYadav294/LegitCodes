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
    int maxLen = 0;

    public int longestUnivaluePath(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            longestUniValue(node, node.val);

            if (node.left != null) {
                q.offer(node.left);
            }

            if (node.right != null) {
                q.offer(node.right);
            }
        }

        return maxLen ;
    }

    public int longestUniValue(TreeNode node, int num) {

         if (node == null || node.val != num) {
        return 0;
    }

        int left = longestUniValue(node.left, num);
        int right  = longestUniValue(node.right, num);
        maxLen = Math.max(maxLen, left+right);
        return 1 + Math.max(left,right);
    }
}