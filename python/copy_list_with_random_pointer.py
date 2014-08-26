#!/usr/bin/env python3

from random_list_node import RandomListNode

class Solution:
    # @param head, a RandomListNode
    # @return a RandomListNode
    def copyRandomList(self, head):
        ptr = head
        while ptr != None:
            post = ptr.next
            ptr.next = RandomListNode(ptr.label)
            ptr.next.next = post
            ptr = post
        ptr = head
        while ptr != None:
            if ptr.random != None:
                ptr.next.random = ptr.random.next
            else:
                ptr.next.random = None
            ptr = ptr.next.next
        copy_head = RandomListNode(0)
        copy_tail = copy_head
        ptr = head
        while ptr != None:
            copy_tail.next = ptr.next
            copy_tail = ptr.next
            ptr.next = ptr.next.next
            ptr = ptr.next;
        return copy_head.next

def main():
    solver = Solution()

if __name__ == '__main__':
    main()
