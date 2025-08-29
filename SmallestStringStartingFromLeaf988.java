
public class SmallestStringStartingFromLeaf988 {
	
	/**
	 * Definition for a binary tree node.
	 * 
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
	 

	  String result = null;

	    public String smallestFromLeaf(TreeNode root) {
	        if(root == null) {
	            return null;
	        }

	        if(root.left == null && root.right == null) {
	            return (char)(root.val+97)+"";
	        }
	        helper(root,  (char)(root.val+97)+"");
	        return result;
	    }


	    public void helper(TreeNode root, String curPath) {
	 
	        
	        if(root.left == null && root.right == null) {
	            getSmall(curPath);
	        }

	        if(root.left != null) {
	            helper(root.left, (char)(root.left.val+97)+curPath);
	        }
	        if(root.right != null) {
	            helper(root.right, (char)(root.right.val+97)+curPath);
	        }
	    }   

	    public void getSmall(String curPath) {
		        int n = 0;
		        int m = 0;

		        if(curPath == null && result == null) {
		            return;
		        }

		        if(curPath == null && result != null) {
		            return;
		        }

		        if(curPath != null && result == null) {
	                System.out.println("result  = "+result);
		            result = curPath;
	                return;
		        }

		        if(curPath.equals(result)) {
		            result = curPath;
	                return;
		        }

		        boolean found = false;
		        if(curPath != null && result != null) {
		            n = curPath.length();
		            m = result.length();
		            int i = 0, j = 0;
		            while(i >= 0 && j >= 0 && i < n && j < m) {
		                if(curPath.charAt(i) < result.charAt(j)) {
		                    result = curPath;
		                    found = true;
		                    break;
		                } else if (curPath.charAt(i) > result.charAt(j)){
		                    result = result;
		                    found = true;
		                    break;
		                } 
		                i++;
		                j++;
		            }
		            
		            if(!found) {
		                if(i < n) {
		                    result = result;
		                } else if(j < m) {
		                    result = curPath;
		                }
		            }
		        

		        
		    }
	        System.out.println("curPath = "+curPath+"  result ="+result);
		    

	    }



	    public static void main(String args[]) {
	    	SmallestStringStartingFromLeaf988 obj = new SmallestStringStartingFromLeaf988();
//	    	System.out.println(obj.getSmall("abc"));
//	    	System.out.println(obj.getSmall("abcd"));
//	    	System.out.println(obj.getSmall("abc"));
//	    	System.out.println(obj.getSmall("bcd"));
	    	
	    	//[0,1,2,3,4,3,4]
	    	TreeNode n1 = obj.new TreeNode(3, null,null);
	    	TreeNode n2 = obj.new TreeNode(4, null,null);
	    	TreeNode n3 = obj.new TreeNode(3, null,null);
	    	TreeNode n4 = obj.new TreeNode(4, null,null);
	    	
	    	
	    	TreeNode n5 = obj.new TreeNode(1, n1, n2);
	    	TreeNode n6 = obj.new TreeNode(2, n3, n4);
	    	
	    	TreeNode n7 = obj.new TreeNode(0, n5, n6);
	    	
	    	String result = obj.smallestFromLeaf(n7);
	    	System.out.println(result);
	    	
	    }


}
