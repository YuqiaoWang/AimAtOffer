/**
 * 面试题18：删除链表的节点
 * O(1)时间
 */
public class DeleteNodeInList {
    public static void deleteNode(ListNode head, ListNode toBeDeleted) {
        if(head == null || toBeDeleted == null) {
            return ;
        }
        //要删除的节点不是尾节点
        if(toBeDeleted.next != null) {
            ListNode nextNode = toBeDeleted.next;
            toBeDeleted.value = nextNode.value;
            toBeDeleted.next = nextNode.next;
        }else if(head == toBeDeleted) {  //如果只有一个节点，删除头节点
            toBeDeleted = null;
            head = null;
        }else { //链表中有多个节点，删除尾节点
            ListNode node = head;
            while(node.next != toBeDeleted) {
                node = node.next;
            }
            node.next = null;
            toBeDeleted = null;
        }

    }
    
}

class ListNode {
    int value;
    ListNode next;
}