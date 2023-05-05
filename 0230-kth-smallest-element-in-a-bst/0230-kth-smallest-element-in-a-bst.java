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
    
    List<Integer> list = new ArrayList<>();
    
    public int kthSmallest(TreeNode root, int k) {
        if(root != null){
            this.inorder(root);
        }
        return list.get(k-1);
    }
    
    public void inorder(TreeNode root){
        if(root.left != null) this.inorder(root.left);
        list.add(root.val);
        if(root.right != null) this.inorder(root.right);
    }
}