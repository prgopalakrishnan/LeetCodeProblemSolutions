import java.util.*;

public class SameTree {
	/**
	 * Definition for a binary tree node.
	 */
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	 

	    public boolean isSameTree(TreeNode p, TreeNode q) {

	        

	        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
	        Queue<TreeNode> q2 = new LinkedList<TreeNode>();

	        q1.add(p);
	        q2.add(q);

	        while(q1.size() > 0 && q2.size() > 0) {
	            int n = q1.size();
	            for(int i =0; i < n; i++) {
	                if((q1.peek() != null && q2.peek() != null &&
	                 q1.peek().val != q2.peek().val) || (q1.size() != q2.size())) {
	                    return false;
	                } else {
	                    TreeNode leftTreeNode = q1.poll();
	                    TreeNode rightTreeNode = q2.poll();
	                    if(leftTreeNode != null) {
	                        q1.add(leftTreeNode.left);
	                        q1.add(leftTreeNode.right);
	                    }
	                    if(rightTreeNode != null) {
	                        q2.add(rightTreeNode.left);
	                        q2.add(rightTreeNode.right);
	                    }
	                }
	            }
	        }

	        return true;
	    }
	
	    public static void main(String[] args) {
	    	TreeNode n1 = new TreeNode()
	    }

}
