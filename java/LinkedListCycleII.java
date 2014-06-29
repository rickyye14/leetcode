public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode token = new ListNode(0);
        token.next = head;
        head = token;
        for (ListNode ptr1 = head, ptr2 = head.next;
                ptr2 != null && ptr2.next != null;
                ptr1 = ptr1.next, ptr2 = ptr2.next.next) {
            if (ptr1 == ptr2) {
                for (ListNode ptr3 = head.next; ; ptr3 = ptr3.next) {
                    do {
                        if (ptr2 == ptr3) {
                            return ptr3;
                        }
                        ptr2 = ptr2.next;
                    } while (ptr2 != ptr1);
                }
            }
        }
        return null;
    }
}
