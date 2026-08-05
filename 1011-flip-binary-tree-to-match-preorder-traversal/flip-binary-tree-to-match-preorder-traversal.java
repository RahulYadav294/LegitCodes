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
    int p = 0;
    boolean possible = true;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> list = new ArrayList<>();

        if (root.val != voyage[0]) {
            list.add(-1);
            return list;
        }

        dfs(root, voyage, list);

        if (!possible)
            return Arrays.asList(-1);

        return list;
    }

    public void dfs(TreeNode root, int[] voyage, List<Integer> list) {

        if (root == null || !possible)
            return;

        
        if (root.val != voyage[p]) {
            possible = false;
            return;
        }

        p++;

        if (root.left != null && p < voyage.length &&
                root.left.val != voyage[p]) {

            list.add(root.val);

            dfs(root.right, voyage, list);
            dfs(root.left, voyage, list);

        } else {

            dfs(root.left, voyage, list);
            dfs(root.right, voyage, list);
        }
    }
}