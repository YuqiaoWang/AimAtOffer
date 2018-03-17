//quenstion 23
public class EntryNodeInListLoop {
    /**
     * 面试题23：链表中环的入口节点
     */
    /**
     * 此方法在链表中存在环的前提下找到一快一慢两个指针相遇的节点
     */
    public ListNode meetNode(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode slow = head;
        if(slow == null) {
            return null;
        }

        ListNode fast = slow.next;
        while(fast != null && slow != null) {
            if(fast == slow) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    /**
     * 得出环中节点的数目，并找到入口
     */
    public ListNode entryNodeofLoop(ListNode head) {
        ListNode meetingNode = meetNode(head);
        if(meetingNode == null) {
            return null;
        }
        int nodesInLoop = 1;
        ListNode node1 = meetingNode;
        while(node1.next != meetingNode) {
            node1 = node1.next;
            nodesInLoop++;
        }

        node1 = head;
        for(int i = 0; i < nodesInLoop; i++) {
            node1 = node1.next;
        }

        ListNode node2 = head;
        while(node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
}

class ListNode {
    int value;
    ListNode next;
}