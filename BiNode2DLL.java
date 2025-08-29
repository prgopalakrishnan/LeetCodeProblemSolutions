

public class BiNode2DLL{

    public BiNode head = null;
    public BiNode prev = null;
    public static boolean isHeadFound = false;
    
 public static void main(String []args){
    System.out.println("Hello World");
    BiNode2DLL bl = new BiNode2DLL();
    
    BiNode n5 = bl.new BiNode(5);
    BiNode n3 = bl.new BiNode(3);
    BiNode n1 = bl.new BiNode(1);
    BiNode n2 = bl.new BiNode(2);
    BiNode n4 = bl.new BiNode(4);
    BiNode n7 = bl.new BiNode(7);
    BiNode n6 = bl.new BiNode(6);
    BiNode n8 = bl.new BiNode(8);
    
    n5.left = n3;
    n5.right = n7;
    
    n3.left = n1;
    n3.right = n4;
    
    n1.left = null;
    n1.right = n2;
    
    n2.left = null;
    n2.right = null;
    
    
    n4.left = null;
    n4.right = null;
    
    n7.left = n6;
    n7.right = n8;
    
    n6.left = null;
    n6.right = null;
    
    n8.left = null;
    n8.right = null;
    
   
    
    bl.inorder(n5);
    
    bl.print(bl.head);
    
    
 }
 
 
 public void print(BiNode head) {
	 while(head != null) {
	        System.out.println(head.val);
	        head = head.right;
	    }
 }
 
 public  void inorder(BiNode root) {
     if(root == null) {
         return;
        
     }
     
     inorder(root.left);
     
     if(!isHeadFound) {
         isHeadFound = true;
         head = root;
     }

     
     if(prev != null) {
    	 prev.right = root;
     }
     root.left = prev;
     
     prev = root;
     
     inorder(root.right);
     
 }
 
 class BiNode {
     
     BiNode(int val) {
         this.val = val;
     }
     public BiNode left = null;
     public BiNode right = null;
     public int val;
 }
 
 
 
}