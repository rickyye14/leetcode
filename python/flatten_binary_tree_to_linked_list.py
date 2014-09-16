#!/usr/bin/env python3

from tree_node import TreeNode

class Solution:
    # @param root, a tree node
    # @return nothing, do it in place
    def flatten(self, root):
        while root:
            if root.left:
                ptr = root.left
                while ptr.right
                    ptr = ptr.right
                ptr.right = root.right
                root.right = root.left
            root.left = None
            root = root.right
