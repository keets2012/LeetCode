package ListNode;


public class LastKNode {
    public Node FindKthToTail(Node head, int k) {
        Node lastK = head;
        int count = 0;
        while (head != null && count < k) {
            head = head.next;
            lastK = head;
            count++;
        }
        while (lastK!=null) {
            head = head.next;
            lastK = lastK.next;
        }
        return head;
    }
}
