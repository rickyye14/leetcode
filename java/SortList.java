public class SortList {
    private class ListFork {
        private ListNode node;
        private ListFork next;

        public ListFork(ListNode node) {
            this.node = node;
            this.next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListFork forkHead = new ListFork(new ListNode(0));
        ListFork forkTail = forkHead;
        int n = 0;
        for (ListNode nodePtr = head; nodePtr != null; nodePtr = nodePtr.next) {
            forkTail.next = new ListFork(nodePtr);
            forkTail = forkTail.next;
            ++n;
        }
        for (ListNode nodePtr = head; nodePtr != null; ) {
            ListNode nodePost = nodePtr.next;
            nodePtr.next = null;
            nodePtr = nodePost;
        }
        for ( ; n > 1; n = (n + 1) / 2) {
            int k = n / 2;
            ListFork forkPtr = forkHead.next;
            for (int i = 0; i < k; ++i, forkPtr = forkPtr.next.next) {
                ListNode tempHead = new ListNode(0);
                ListNode tempTail = tempHead;
                ListNode firstPtr = forkPtr.node;
                ListNode lastPtr = forkPtr.next.node;
                while (firstPtr != null && lastPtr != null) {
                    if (firstPtr.val < lastPtr.val) {
                        tempTail.next = firstPtr;
                        firstPtr = firstPtr.next;
                    } else {
                        tempTail.next = lastPtr;
                        lastPtr = lastPtr.next;
                    }
                    tempTail = tempTail.next;
                }
                while (firstPtr != null) {
                    tempTail.next = firstPtr;
                    firstPtr = firstPtr.next;
                    tempTail = tempTail.next;
                }
                while (lastPtr != null) {
                    tempTail.next = lastPtr;
                    lastPtr = lastPtr.next;
                    tempTail = tempTail.next;
                }
                forkPtr.node = tempHead.next;
            }
            forkPtr = forkHead.next;
            for (int i = 0; i < k; ++i, forkPtr = forkPtr.next) {
                forkPtr.next = forkPtr.next.next;
            }
        }
        return forkHead.next.node;
    }
}
