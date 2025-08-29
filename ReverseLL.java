
public class ReverseLL {



/**
 * Definition for singly-linked list.
 */
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        if(head.next.next == null) {
            ListNode newhead = head.next;
            newhead.next = head;
            return newhead;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = cur.next;

        while(next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }

        cur.next = prev;
        return cur;
     }
    
    
    public static void main(String args[]) {
    	
    	System.out.println("Hello");
    	
    	ReverseLL reverseLLObj = new ReverseLL();
    	ListNode l1 = reverseLLObj.new ListNode(1, null);
    	ListNode l2 = reverseLLObj.new ListNode(2, l1);
    	ListNode l3 = reverseLLObj.new ListNode(3, l2);
    	ListNode l4 = reverseLLObj.new ListNode(4, l3);
    	
    	reverseLLObj.reverseList(l4);
    	
    }
}

