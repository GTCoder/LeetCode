/**
 * 1. Add a dummy head
 * 2. Use two while loops
 * 3. Remember this piece of code:
 *         prev.next = cur;
 *         cur = cur.next;
 *         prev = prev.next;
 *    Note that prev is touched TWICE here!
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Validate input
        if (head == null || head.next == null) {
            return head;
        }
        
        // Add a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode cur = head;
        
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            prev.next = cur;
            cur = cur.next;
            prev = prev.next;
        }
        
        return dummy.next;
    }
}