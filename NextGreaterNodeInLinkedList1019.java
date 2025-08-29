
public class NextGreaterNodeInLinkedList1019 {
	
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
	 
	    public int[] nextLargerNodes(ListNode head) {
	        /**
	        List<Integer> result = new ArrayList();
	        ListNode start = head;
	        while(start != null) {
	            ListNode tmpStart = start.next;
	            while(tmpStart != null && tmpStart.val <= start.val) {
	                tmpStart = tmpStart.next;
	            }
	            if(tmpStart != null) {
	                result.add(tmpStart.val);
	            } else {
	                result.add(0);
	            }
	            
	            start = start.next;
	        }
	        
	        int[] resultArr = new int[result.size()];
	        for(int i = 0; i < result.size(); i++) {
	            resultArr[i] = result.get(i);
	        }
	        
	        return resultArr;
	        */
	        int cnt = reverse(head);
	        int[] result = new int[cnt];
	        cnt = cnt-1;
	        
	        int i =0;
	        
	        
	        
	        int max = head.val;
	        
	        while(head != null) {
	            if(max <=  head.val) {
	                result[cnt--] = 0;
	                max = head.val;
	            } else {
	                result[cnt--] = max;
	            }
	            
	            head = head.next;
	        }
	        
	        return result;
	    }
	    
	    
	    public int reverse(ListNode head) {
	        
	       
	        
	        int cnt = 0;
	        
	        ListNode prev = null;
	        ListNode cur = head;
	        ListNode next = cur.next;
	        
	        while(cur != null) {
	            cnt++;
	            cur.next = prev;
	            prev = cur;
	            cur = next;
	            if(next != null) {
	                next = next.next;
	            }
	        }
	        
	        head = prev;
	        return cnt;
	    }
	

}
