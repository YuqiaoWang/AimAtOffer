/**
 * 面试题52：两个链表的第一个公共节点
 */
public class CommonNode {
    public static ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        
        int nodesNum1 = getListLength(head1);
        int nodesNum2 = getListLength(head2);
        int numDiff = Math.abs(nodesNum1 - nodesNum2);
        ListNode long = (nodesNum1 < nodesNum2) ? head2 : head1;
        ListNode short = (nodesNum1 < nodesNum2) ? head1 : head2;

        //先在长链表上走几步，再同时在两个链表上遍历
        for(int i = 0; i < numDiff; i++) {
            long = long.next;
        }
        while(long != null && short != null && long != short) {
            long = long.next;
            short = short.next;
        }
        //得到第一个公共节点
        ListNode firstCommonNode = long;
        return firstCommonNode;

    }

    public static int getListLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while(node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
    
}

class ListNode {
    int value;
    ListNode next;
}