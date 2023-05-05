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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        Deque<TreeNode> q = new ArrayDeque<>();
        if(root == null){
            return res;
        }
        q.add(root);
        
        while(q.size() > 0){
            int qLen = q.size();
            
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<qLen; i++){
                TreeNode t = q.poll();
                level.add(t.val);
                
                if(t.left !=null){
                    q.add(t.left);
                }
                
                if(t.right != null){
                    q.add(t.right);
                }
            }
            res.add(level);
        }
        
        return res;
    }
    
}