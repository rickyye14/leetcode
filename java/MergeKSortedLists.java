import java.util.ArrayList;

public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null) {
            return null;
        }
        int n = lists.size();
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return lists.get(0);
        }
        ListNode[] ptrs = new ListNode[n];
        for (int i = 0; i < lists.size(); ++i) {
            ptrs[i] = lists.get(i);
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (true) {
            boolean flag = true;
            for (int i = 0; i < n; ++i) {
                if (ptrs[i] == null) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            for (int i = 1; i < n; ++i) {
                if (ptrs[i - 1].val != ptrs[i].val) {
                    flag = false;
                    break;
                } else {
                    tail.next = new ListNode(ptrs[i].val);
                    tail = tail.next;
                }
            }
            if (!flag) {
                break;
            }
            for (int i = 0; i < n; ++i) {
                ptrs[i] = ptrs[i].next;
            }
        }
        return head.next;
    }
}
