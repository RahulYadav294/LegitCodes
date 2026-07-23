/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        StringBuilder sb = new StringBuilder();
        String data = helper(root,sb);
        return data;
    }
    String helper(TreeNode root,StringBuilder sb){
        if(root == null){ 
        return sb.append("null,").toString(); 
        }
        sb.append(root.val).append(",");
        helper(root.left,sb);
        helper(root.right,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(str));
       TreeNode roots =   buildTree(q);
       return roots;
    }
    TreeNode buildTree(Queue<String> q){
        String num = q.poll();
        if(num.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(num));
        node.left  =  buildTree(q);
        node.right = buildTree(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));