#!/usr/bin/env python3

class TreNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None

class Solution:
    # @param root, a tree node
    # @return nothing
    def connect(self, root):
        ptr = root
        while ptr:
            first = None
            prev = None
            while ptr:
                if ptr.left:
                    if first is None:
                        first = ptr.left
                    if prev:
                        prev.next = ptr.left
                    prev = ptr.left
                if ptr.right:
                    if first is None:
                        first = ptr.right
                    if prev:
                        prev.next = ptr.right
                    prev = ptr.right
                ptr = ptr.next
            ptr = first
