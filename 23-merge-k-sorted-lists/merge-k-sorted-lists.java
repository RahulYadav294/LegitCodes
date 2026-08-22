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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists == null) return null;
        return divide(lists, 0, lists.length-1);
    }
    public ListNode divide(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        if(left > right) return null;
        int mid = left + (right - left)/2;
        ListNode leftList = divide(lists,left, mid);
        ListNode rightList = divide(lists,mid+1, right);
        return  merge( leftList, rightList);
    }
    public ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(a != null && b != null){
            if(a.val < b.val){
                curr.next = a;
                a = a.next;
            }else{
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        if(a != null){
            curr.next = a;
        }
        if(b != null){
            curr.next = b;
        }
        return dummy.next;
    }
}