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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        helperLeftSubTree(root);
    }
    void helperLeftSubTree(TreeNode root){
        if(root == null) return;
        helperLeftSubTree(root.right);
        helperLeftSubTree(root.left);  
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

 // Approach1 using space
 /*
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        List<TreeNode> list = new ArrayList<>();
        helper(root,list);
        for(int i = 0; i<list.size()-1; i++){
            list.get(i).left = null;
            list.get(i).right = list.get(i+1);
        }
        list.get(list.size()-1).left = null;
        list.get(list.size()-1).right = null;
    }
   void helper(TreeNode root,List<TreeNode> list){
        if(root == null) return ;
        list.add(root);
        helper(root.left,list);
        helper(root.right,list);
    }
}
*/