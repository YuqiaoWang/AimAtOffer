//question 25
public class MergedHead {
    public ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null) {
            return head2;
        }
        if(head2 == null) {
            return head1;
        }
        ListNode mergeHead = null;
        if((head1.next).value < (head2.next).value) {
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