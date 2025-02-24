class Solution {
    public:
        int checkHeight(TreeNode* root) {
            if (!root) return 0; // Base case: height of null node is 0
    
            int leftHeight = checkHeight(root->left);
            if (leftHeight == -1) return -1; // Left subtree is unbalanced
    
            int rightHeight = checkHeight(root->right);
            if (rightHeight == -1) return -1; // Right subtree is unbalanced
    
            if (abs(leftHeight - rightHeight) > 1) return -1; // Current node is unbalanced
    
            return max(leftHeight, rightHeight) + 1; // Return the height of the subtree
        }
    
        bool isBalanced(TreeNode* root) {
            return checkHeight(root) != -1;
        }
    };
    