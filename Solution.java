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
    public void preorder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        preorder(root, list);
        root.left = null;
        root.right = null;
        TreeNode current = root;
        for(int i = 1; i < list.size(); i++){
            TreeNode t = new TreeNode(list.get(i), null, null);
            current.right = t;
            current = current.right;
        }
    }
}
