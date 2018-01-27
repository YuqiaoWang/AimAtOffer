
//question 35
public class CopyComplexList {
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