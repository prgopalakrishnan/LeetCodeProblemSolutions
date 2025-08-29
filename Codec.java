
 import java.util.*;

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

 public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return null;
        }
        StringBuffer buf = new StringBuffer();
        helperSerialize(root, buf);
        System.out.println(buf.toString());
        String result = buf.toString();
        return result.substring(0, 19);
    }

    //public String removeNull()

    public void helperSerialize(TreeNode root, StringBuffer buf) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(queue.size() > 0) {
            TreeNode node = queue.remove();
            if (node != null) {
                buf.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                buf.append(null+",");
            }
            
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        TreeNode curNode = null;
        int i = 0;
        System.out.println("data = "+data);
        if(data != null && data.length() > 0) {
            String[] tokens = data.split(",");
            for(int j = 0; j < tokens.length; j++) {
                System.out.println(" token = "+tokens[j]);
            }
            root = new TreeNode(Integer.parseInt(tokens[i]));
            curNode = root;
            List<TreeNode> nodes = new ArrayList();
            nodes.add(curNode);
            while( i < tokens.length) {
                curNode = nodes.get(i);
                System.out.println("curNode = "+curNode.val+" i = "+i);
                if(curNode != null) {
                    if(2*i+1 < tokens.length) {

                        curNode.left = (tokens[2*i+1].equals("null")) ?null : new TreeNode(Integer.parseInt(tokens[2*i+1]));
                        nodes.add(curNode.left);
                    }
                    if(2*i+2 < tokens.length) {
                        curNode.right = (tokens[2*i+2].equals("null")) ? null : new TreeNode(Integer.parseInt(tokens[2*i+2]));
                        nodes.add(curNode.right);
                    }
                }
                
                i++;
                
            }
        }
        System.out.println("root.val = "+root.val);
        printNode(root);
        return root;
    }

    public void printNode(TreeNode root){
        if(root == null) {
            return;
        }

        System.out.print(root.val+" ");
        printNode(root.left);
        printNode(root.right);
    }
}
