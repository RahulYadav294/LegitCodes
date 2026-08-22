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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = 0;
        ListNode c = head;
        while(c != null){
            len++;
            c = c.next;
        }
        int d = k % len;

        for (int i = 0; i < d; i++) {

            ListNode prev = null;
            ListNode curr = head;

            // Find last node
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            // Detach last node
            prev.next = null;

            // Put last node at head
            curr.next = head;
            head = curr;
        }

        return head;
    }
}