/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        boolean f=true;boolean s=true;
        while(s){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                f=true;
                s=false;
            }
            else if(fast==null){
                f=false;
                s=false;
            }
            else if(fast.next==null){
                f=false;
                s=false;
            }
        }
        return f;
    }
}