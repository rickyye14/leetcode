#!/usr/bin/env python3

from list_node import ListNode

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def sortList(self, head):
        temp = ListNode(0)
        temp.next = head
        head = temp
        size = 0
        ptr = head.next
        while ptr:
            ptr = ptr.next
            size += 1
        for step in range(1, size // 2 + 1):
            h1 = head

    def mergeTwoLists(self, l1, l2):
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

if __name__ == '__main__':
    main()
