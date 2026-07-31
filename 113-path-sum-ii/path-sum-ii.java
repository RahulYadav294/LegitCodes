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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> bigList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        validPath(root,bigList,list,0,targetSum);
        return bigList;
    }
    public void validPath(TreeNode root,List<List<Integer>> bigList,
            List<Integer> list,int sum,int targetSum){
                if(root == null) return;
                list.add(root.val);
                sum+=root.val;
                if(root.left == null && root.right == null && sum == targetSum){
                    bigList.add(new ArrayList<>(list));
                }
                validPath(root.left,bigList,list,sum,targetSum);
                validPath(root.right,bigList,list,sum,targetSum);
                list.remove(list.size()-1);
            }
}