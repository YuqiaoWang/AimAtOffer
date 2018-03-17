/**
 * 面试题35：复杂链表的复制
 * O(n)空间消耗
 * O(n)时间复杂
 */
public class CopyComplexList {
    /**
     * 第一步：复制原始链表任意节点N并创建新节点N'，再把N'链接到N的后面
     */
    public void cloneNodes(ComplexListNode head) {
        ComplexListNode node = head;
        while(node != null) {
            ComplexListNode cloned = new ComplexListNode();
            cloned.value = node.value;
            cloned.next = node.next;
            cloned.sibling = null;
            node.next = cloned;
            node = cloned.next;
        }
    }

    /**
     * 第二步：设置复制出来的节点sibling，
     */
    public void connectSiblingNodes(ComplexListNode head) {
        ComplexListNode node = head;
        while(node != null) {
            ComplexListNode cloned = node.next;
            if(node.sibling != null) {
                cloned.sibling = node.sibling.next;
            }
            node = cloned.next;
        }
    }

    /**
     * 把这个长链表拆分成2个链表，分奇偶位置
     */
    public ComplexListNode reconnectNodes(ComplexListNode head) {
        ComplexListNode node = head;
        ComplexListNode clonedHead = null;
        ComplexListNode clonedNode = null;
        if(node != null) {
            clonedHead = clonedNode = node.next;
            node.next = clonedNode.next;
            node = node.next;
        }

        while(node != null) {
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node.next = clonedNode.next;
            node = node.next;
        }
        return clonedHead;
    }

    public ComplexListNode clone(ComplexListNode head) {
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }
}


class ComplexListNode{
    int value;
    ComplexListNode next;
    ComplexListNode sibling;
}