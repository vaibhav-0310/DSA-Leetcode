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
      public void flatten(TreeNode root) {
        find(root);
        
    }

    public TreeNode find(TreeNode root){
        if(root==null) return null;

        
        TreeNode templ = find(root.left);
        TreeNode tempr = find(root.right);

        if(root.left!=null){
            TreeNode rightfirst = root.right;
            root.right = root.left;
            root.left=null;

            if(templ!=null) templ.right = rightfirst;
        }

        if(tempr!=null) return tempr;
        if(templ!=null) return templ;
        return root;
    }
}