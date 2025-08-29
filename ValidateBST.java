
import java.util.*;

public class ValidateBST {
	
	
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
	/**
	  {10, 5, 1, 7, 40, 50} N L R
	   */
	  public TreeNode bstFromPreorder(int[] preorder) {
	        return helper(preorder, 0, preorder.length-1);
	  }



	  public int binarySearch(int[] a, int key, int start, int end) {
	    if(start > end) {
	      return -1;
	    }

	    int mid = (start+end)/2;
	    if(a[mid] > key && mid == start) {
	        return mid;
	    } else if(a[mid] > key && mid-1 > 0 && a[mid-1] <= key) {
	        return mid;
	    } else if(a[mid] <= key) {
	        return binarySearch(a, key, mid+1, end);
	    } else {
	    	return binarySearch(a, key, start, mid-1);
	    }
	    
	    
	    
	  }
	  

	  public TreeNode helper(int[] arr, int start, int end) {
	    if(start > end) {
	      return null;
	    }
	    
	    TreeNode node = new TreeNode(arr[start], null,  null);
	 
	    if(start == end) {
	        return node;
	    }
	    /** 
	    int index = start+1;
		while(index <= end && arr[index] <= arr[start]) {
		    index++;
		}
	    */
	    int index = binarySearch(arr, arr[start], start+1, end);
	    if(index == -1) {
	        index = start+1;
	    }

	    node.left = helper(arr, start+1, index-1);
	    node.right = helper(arr, index, end);
	    return node;

	  }

	  public void printTreeBFS(TreeNode root) {
		  Queue<TreeNode> q = new LinkedList<TreeNode>();
		  q.add(root);
		  while(q.size() > 0) {
			  TreeNode node = q.remove();
			  if(node != null) {
				  System.out.print(" " + node.val);
				  q.add(node.left);
			      q.add(node.right);
			  } else {
				  System.out.print(" null");
			  }
			  
		  }
		  
	  }
	  
	  
	  public static void main(String[] args) {
		  ValidateBST obj = new ValidateBST();
		  
		  obj.printTreeBFS(node);
	  }

}
