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
 class State{
    TreeNode node;
    int max;
    int min;
    State(TreeNode node, int max, int min){
        this.node = node;
        this.max = max;
        this.min = min;
    }
 }
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        Queue<State> q = new LinkedList<>();
        q.offer(new State(root,root.val,root.val));
        int maxDiff = 0;
        while(!q.isEmpty()){
            State curr = q.poll();
            TreeNode node = curr.node ;
            int max = curr.max;
            int min = curr.min;
            maxDiff = Math.max(maxDiff, Math.max(Math.abs(node.val - max),Math.abs(node.val-min)));
            int newMin = Math.min(node.val,min);
            int newMax = Math.max(node.val,max);
            if(node.left != null){
                q.offer(new State(node.left,newMax,newMin));
            }
             if(node.right != null){
                q.offer(new State(node.right,newMax,newMin));
            }

        }
        return maxDiff;
    }
}