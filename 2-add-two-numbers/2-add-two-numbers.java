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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val + carry;
            
            if (value <= 9) {
                temp.next = new ListNode(value);
                carry = 0;
            } else {
                temp.next = new ListNode(value % 10);
                carry = 1;
            }
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 != null && l2 == null) {
            while (l1 != null) {
                int value = l1.val + carry;
            
                if (value <= 9) {
                    temp.next = new ListNode(value);
                    carry = 0;
                } else {
                    temp.next = new ListNode(value % 10);
                    carry = 1;
                }
                temp = temp.next;
                l1 = l1.next;
            }
        }
        
        if (l1 == null && l2 != null) {
            while (l2 != null) {
                int value = l2.val + carry;
            
                if (value <= 9) {
                    temp.next = new ListNode(value);
                    carry = 0;
                } else {
                    temp.next = new ListNode(value % 10);
                    carry = 1;
                }
                temp = temp.next;
                l2 = l2.next;
            }
        }
        
        if (carry > 0) {
            temp.next = new ListNode(carry);
            temp = temp.next;
        }
        
        return result.next;
    }
}