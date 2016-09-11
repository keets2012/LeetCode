package tree;

public class CopyTree {
    public RandomListNode Clone(RandomListNode pHead) {
        if (null==pHead)
            return null;
        RandomListNode cur = pHead;
        while (cur!= null) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = pHead;
        while (cur!= null) {
            RandomListNode node = cur.next;
            if (cur.random!=null) {
                node.random = cur.random.next;
            }
            cur = cur.next;
        }

        //拆分
        RandomListNode pCNode = pHead.next;
        cur = pHead;
        RandomListNode tmp ;
        while (cur!=null) {
            tmp = cur.next;
            cur.next = tmp.next;
            cur = tmp;
        }
        return pCNode;
    }
}
