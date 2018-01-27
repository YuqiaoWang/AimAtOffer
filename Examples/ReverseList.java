//question 24
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode reversedHead = null;
        ListNode node = head;
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            if(next == null) {
                reversedHead = node;
            }
            node.next = prev;
            prev = node;
            node = next;
        }
        return reversedHead;
    }
}

class ListNode {
    int value;
    ListNode next;
}