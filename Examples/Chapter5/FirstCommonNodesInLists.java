
//question 52
public class FirstCommonNodesInLists {
    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        int length1 = getListLength(head1);
        int length2 = getListLength(head2);
        int lengthDif = length1 - length2;

        ListNode listHeadLong = head1;
        ListNode listHeadShort = head2;

        if(length2 > length1) {
            listHeadLong = head2;
            listHeadShort = head1;
            lengthDif = length2 - length1;
        }

        for(int i = 0; i < lengthDif; i++) {
            listHeadLong = listHeadLong.next;
        }
        while((listHeadLong != null) && (listHeadShort != null) && (listHeadLong != listHeadShort)) {
            listHeadLong = listHeadLong.next;
            listHeadShort = listHeadShort.next;
        }
        ListNode firstCommonNode = listHeadLong;
        return firstCommonNode;
    }

    public int getListLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while(node != null) {
            ++length;
            node = node.next;
        }
        return length;
    }
}

public class ListNode {
    int key;
    ListNode next;
}