/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class LC143ReorderLinkedList {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        if(head.next == null) {
            return;
        }
        
        //find the start of second node
        ListNode secondListHead = getSecondListHead(head);
        secondListHead = reverseList(secondListHead);
        ListNode firstListHead = head;
        ListNode curNode = secondListHead;
        ListNode prevNode = firstListHead;
        while(firstListHead != null && secondListHead != null) {
            curNode = secondListHead;
            secondListHead = secondListHead.next;
            prevNode = firstListHead;
            firstListHead = firstListHead.next;
            curNode.next = prevNode.next;
            prevNode.next = curNode;
        }

        if(secondListHead != null) {
            curNode.next = secondListHead;
            secondListHead.next = null;
        }

        if(firstListHead != null) {
            curNode.next = firstListHead;
            firstListHead.next = null;
        }
    }

    public ListNode getSecondListHead(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        ListNode prev = null;
        while(second != null) {
            second = second.next;
            second = second == null ? null : second.next;
            prev = first;
            first = first.next;
        }
        
        prev.next = null;
        return first;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode  cur = head;
        ListNode next = head.next;
        while(cur != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next == null ? null : next.next;
        }
        return prev;
    }


}
