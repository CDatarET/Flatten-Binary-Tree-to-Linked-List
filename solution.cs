/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public void Preorder(TreeNode root, List<int> list){
        if(root == null){
            return;
        }

        list.Add(root.val);
        Preorder(root.left, list);
        Preorder(root.right, list);
    }
    public void Flatten(TreeNode root) {
        if(root == null){
            return;
        }
        List<int> list = new List<int>();
        Preorder(root, list);
        root.left = null;
        root.right = null;
        TreeNode current = root;
        for(int i = 1; i < list.Count(); i++){
            TreeNode t = new TreeNode(list[i], null, null);
            current.right = t;
            current = current.right;
        }
    }
}
