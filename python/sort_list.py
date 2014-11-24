#!/usr/bin/env python3

from list_node import ListNode

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    # top to bottom version (recursion)
    def sortList(self, head):
        if not head or not head.next:
            return head
        n = 0
        ptr = head
        while ptr:
            ptr = ptr.next
            n += 1
        l1 = head
        l2 = head
        for i in range(n // 2 - 1):
            l2 = l2.next
        tmp = l2
        l2 = tmp.next
        tmp.next = None
        l1 = self.sortList(l1)
        l2 = self.sortList(l2)
        return self.merge(l1, l2)

    def merge(self, l1, l2):
        head = ListNode(0)
        tail = head
        while l1 and l2:
            if l1.val < l2.val:
                tail.next = l1
                l1 = l1.next
            else:
                tail.next = l2
                l2 = l2.next
            tail = tail.next
        while l1:
            tail.next = l1
            l1 = l1.next
            tail = tail.next
        while l2:
            tail.next = l2
            l2 = l2.next
            tail = tail.next
        return head.next

    # @param head, a ListNode
    # @return a ListNode
    # bottom to top version (non-recursion)
    def sortList2(self, head):
        if not head or not head.next:
            return head
        n = 0
        ptr = head
        while ptr:
            ptr = ptr.next
            n += 1
        step = 1
        sentry = ListNode(0)
        while step < n:
            sentry.next = head
            prev = sentry
            while prev.next:
                head1 = prev.next
                tail1 = head1
                for i in range(step - 1):
                    if tail1.next is None:
                        break
                    tail1 = tail1.next
                if tail1.next is None:
                    break
                head2 = tail1.next
                tail2 = head2
                tail1.next = None
                for i in range(step - 1):
                    if tail2.next is None:
                        break
                    tail2 = tail2.next
                post = tail2.next
                tail2.next = None
                prev.next = self.merge(head1, head2)
                tail = prev.next
                while tail.next:
                    tail = tail.next
                tail.next = post
                prev = tail
            head = sentry.next
            step <<= 1
        return head

    def merge(self, l1, l2):
        head = ListNode(0)
        tail = head
        while l1 and l2:
            if l1.val < l2.val:
                tail.next = l1
                l1 = l1.next
            else:
                tail.next = l2
                l2 = l2.next
            tail = tail.next
        while l1:
            tail.next = l1
            l1 = l1.next
            tail = tail.next
        while l2:
            tail.next = l2
            l2 = l2.next
            tail = tail.next
        return head.next

def main():
    solver = Solution()
    head = ListNode(3)
    head.next = ListNode(2)
    solver.sortList2(head)
    ptr = head
    while ptr:
        print(ptr.val)
        ptr = ptr.next
    head = ListNode(2)
    head.next = ListNode(1)
    solver.sortList2(head)
    ptr = head
    while ptr:
        print(ptr.val)
        ptr = ptr.next

if __name__ == '__main__':
    main()
