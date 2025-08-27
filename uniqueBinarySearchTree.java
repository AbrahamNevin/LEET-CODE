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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return buildTrees(1, n);
    }
    
    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        
        // Base case
        if (start > end) {
            res.add(null);
            return res;
        }
        
        // Choose root
        for (int i = start; i <= end; i++) {
            // All possible left subtrees
            List<TreeNode> leftTrees = buildTrees(start, i - 1);
            // All possible right subtrees
            List<TreeNode> rightTrees = buildTrees(i + 1, end);
            
            // Combine left and right with root = i
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}
