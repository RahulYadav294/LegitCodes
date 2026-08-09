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

    int ans = 0;

    public int longestZigZag(TreeNode root) {

        if (root == null) return 0;

        // Start a path by going LEFT
        dfs(root.left, false, 1);

        // Start a path by going RIGHT
        dfs(root.right, true, 1);

        return ans;
    }

    // lastWasRight = true  → previous move was RIGHT
    // lastWasRight = false → previous move was LEFT
    void dfs(TreeNode node, boolean lastWasRight, int len) {

        if (node == null) return;

        ans = Math.max(ans, len);

        if (lastWasRight) {

            // Previous move was RIGHT
            // So continue ZigZag by going LEFT
            dfs(node.left, false, len + 1);

            // Start a NEW path by going RIGHT
            dfs(node.right, true, 1);

        } else {

            // Previous move was LEFT
            // So continue ZigZag by going RIGHT
            dfs(node.right, true, len + 1);

            // Start a NEW path by going LEFT
            dfs(node.left, false, 1);
        }
    }
}