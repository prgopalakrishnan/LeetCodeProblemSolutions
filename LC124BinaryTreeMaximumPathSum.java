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

class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);


        int curSum = root.val + Math.max(leftSum, rightSum);
        curSum = Math.max(root.val, curSum);
        curSum = Math.max(root.val+leftSum+rightSum, curSum);
        maxSum = (maxSum < curSum) ? curSum : maxSum;
        int sumWithoutSplit = Math.max(root.val+leftSum, root.val+rightSum);
        sumWithoutSplit = Math.max(root.val, sumWithoutSplit);
        return sumWithoutSplit;
        
    }
}
