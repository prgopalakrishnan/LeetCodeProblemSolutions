

import java.util.*;

public class BinaryTreeVerticalOrderTraversalLC314 {



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
 * 
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
	
	
    public List<List<Integer>> verticalOrder(TreeNode root) {

        if(root == null) {
            return null;
        }
        Queue<QElem> q = new LinkedList();
        Map<Integer, List<Integer>> elemMap = new TreeMap();

        QElem elem = new QElem(root, 0);
        List<Integer> elemList = new ArrayList();
        elemList.add(root.val);
        elemMap.put(0, elemList);
        q.add(elem);
        
        int curFlatLevel = 0;
        while(q.size() > 0) {
            QElem qElem = q.remove();
            if(qElem.getTreeNode().left != null) {
                QElem newElem = addElem(elemMap, qElem, 0);
                q.add(newElem);
            }
            if(qElem.getTreeNode().right != null) {
                QElem newElem = addElem(elemMap, qElem, 1);
                 q.add(newElem);
            }
        }

        List<List<Integer>> resultList = new ArrayList();
        for(List list: elemMap.values()) {
            resultList.add(list);
        }

        return resultList;
    }

    // 0 means left
    // 1 means right
    public QElem addElem(Map<Integer, List<Integer>> elemMap, QElem qElem, int dir) {
        int curFlatLevel = 0;
        TreeNode node = null;
        QElem newElem = null;

        if(dir == 0) {
            curFlatLevel = qElem.flatLevel-1;
            node = qElem.getTreeNode().left;
        } else {
            curFlatLevel = qElem.flatLevel+1;
            node = qElem.getTreeNode().right;
        }
        newElem = new QElem(node, curFlatLevel);
        if(elemMap.containsKey(curFlatLevel)) {
            List<Integer> list = elemMap.get(curFlatLevel);
            list.add(node.val);
        } else {
            List<Integer> list = new ArrayList();
            list.add(node.val);
            elemMap.put(curFlatLevel, list);
        }

        return newElem;
    }


     class QElem {
        TreeNode root = null;
        int flatLevel = 0;


        public TreeNode getTreeNode() {
            return root;
        }

        public int getFlatLevel() {
            return flatLevel;
        }
 
        public QElem(TreeNode root, int flatLevel) {
            this.root = root;
            this.flatLevel = flatLevel;
        }
    }
    
    
    public static void main(String args[]) {
    	BinaryTreeVerticalOrderTraversalLC314 obj = new BinaryTreeVerticalOrderTraversalLC314();
    	TreeNode n3 = obj.new TreeNode(3);
    	TreeNode n9 = obj.new TreeNode(9);
    	TreeNode n8 = obj.new TreeNode(8);
    	TreeNode n4 = obj.new TreeNode(4);
    	TreeNode n0 = obj.new TreeNode(0);
    	TreeNode n1 = obj.new TreeNode(1);
    	TreeNode n7 = obj.new TreeNode(7);
    	TreeNode n5 = obj.new TreeNode(5);
    	TreeNode n2 = obj.new TreeNode(2);
    	
    	n3.left = n9; n3.right = n8;
    	n9.left = n4; n9.right = n0;
    	n8.left = n1; n8.right = n7;
    	n0.left = n5; n0.right = n2;
    	
    	//obj.print(n3);
    	
    	List<List<Integer>> list = obj.verticalOrder(n3);
    	for(List<Integer> elemList: list) {
    		for(Integer elem: elemList) {
    			System.out.print(" "+elem);
    		}
    	}
    	
    }
    
    public void print(TreeNode root) {
    	Queue<TreeNode> q = new LinkedList();
    	q.add(root);
    	while(q.size() > 0) {
    		TreeNode cur = q.remove();
    		System.out.print(" "+cur.val);
    		if(cur.left != null) {
    			q.add(cur.left);
    		}
    		if(cur.right != null) {
    			q.add(cur.right);
    		}
    	}
    }
    
    
}