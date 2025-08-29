/**
 * 
 *
 * Definition for a binary tree node.
 */
   class TreeNode {
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


public class TreeFromPreInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int index, int low, int high) {
        if(index >= preorder.length) {
            return null;
        }

        if(low > high) {
            return null;
        }

        int rootIndex = search(preorder[index], inorder, low, high);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        if(low == rootIndex) {
            root.left = null;
        } else {
        	index = index +1;
            root.left = helper(preorder, inorder, index, low, rootIndex-1);
        }
        if(rootIndex == high) {
            root.right = null;
        } else {
        	index = index +1;
            root.right = helper(preorder, inorder, index, rootIndex+1, high);
        }
        return root;
    }

    public int search(int key, int[] inorder, int low, int high) {
        int index = -1;
        for(int i = low; i <= high; i++) {
            if(inorder[i] == key) {
                index = i;
                break;
            }
        }
        System.out.println("key "+key+ " low = "+low+ " high = "+high+ "index = "+index);
        return index;
    }
    
    
    public static void main(String args[]) {
    	int[] preorder = {1,2,3,4}; 
    	int[] inorder = {2,1,3,4};
    	
    	TreeFromPreInorder tp = new TreeFromPreInorder();
    	TreeNode root = tp.buildTree(preorder, inorder);
    	System.out.println(root.val);

    }
    
}