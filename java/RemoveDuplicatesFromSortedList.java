public class RemoveDuplicatesFromSortedArray {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = new ListNode(0);
        ListNode last = first;
        ListNode start = head;
        ListNode end = null;
        while (start != null) {
            end = start;
            while (end != null && start.val == end.val) {
                end = end.next;
            }
            last.next = start;
            last = last.next;
            start = end;
        }
        last.next = null;
        return first.next;
    }
}
