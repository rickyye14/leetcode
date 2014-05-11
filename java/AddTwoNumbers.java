public class AddTwoNumbers {
    private class ListNode {
        private int val;
        private ListNode next;
        
        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int carry = 0;
        for ( ; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next, tail = tail.next) {
            tail.next = new ListNode(l1.val + l2.val + carry);
            if (tail.next.val >= 10) {
                carry = 1;
                tail.next.val -= 10;
            } else {
                carry = 0;
            }
        }
        for ( ; l1 != null; l1 = l1.next, tail = tail.next) {
            tail.next = new ListNode(l1.val + carry);
            if (tail.next.val >= 10) {
                carry = 1;
                tail.next.val -= 10;
            } else {
                carry = 0;
            }
        }
        for ( ; l2 != null; l2 = l2.next, tail = tail.next) {
            tail.next = new ListNode(l2.val + carry);
            if (tail.next.val >= 10) {
                carry = 1;
                tail.next.val -= 10;
            } else {
                carry = 0;
            }
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String[] args) {
    }
}
