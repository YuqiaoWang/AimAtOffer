public class KthNodeFromEnd{
    /**
     * 面试题22：链表中倒数第k个节点
     */
    static ListNode finfKthToTail(ListNode head, int k) {
        if(head == null || k == 0) {
            return null;
        }
        ListNode ahead = head;
        ListNode behind = head;
        for(int i = 0; i < k; i++) {
            if(ahead.next != null) {
                ahead = ahead.next;
            }else {
                return null;
            }
        }

        while(ahead.next != null) {
            behind = behind.next;
            ahead = ahead.next;
        }
        return behind;
    }
}

class ListNode {
    int val;
    ListNode next;
}