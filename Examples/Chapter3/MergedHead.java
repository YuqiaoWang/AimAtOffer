//question 25
public class MergedHead {
    /**
     * 面试题25：合并两个排序的链表
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        ListNode mergeHead = null;
        if(head1.value < head2.value) {
            mergeHead = head1;
            mergeHead.next = merge(head1.next, head2)
        }else {
            mergeHead = head2;
            mergeHead.next = merge(head1, head2.next);
        }
        return mergeHead;
    }
}

class ListNode {
    int value;
    ListNode next;
}