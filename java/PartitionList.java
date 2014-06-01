public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lessFirst = new ListNode(0);
        ListNode lessLast = lessFirst;
        ListNode greaterFirst = new ListNode(0);
        ListNode greaterLast = greaterFirst;
        for ( ; head != null; head = head.next) {
            if (head.val < x) {
                lessLast.next = head;
                lessLast = lessLast.next;
            } else {
                greaterLast.next = head;
                greaterLast = greaterLast.next;
            }
        }
        lessLast.next = greaterFirst.next;
        greaterLast.next = null;
        return lessFirst.next;
    }
}
