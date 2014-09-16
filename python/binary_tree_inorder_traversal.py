#!/usr/bin/env python3

from tree_node import TreeNode

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def inorderTraversal(self, root):
        res = list()
        curr = root
        while curr:
            if curr.left is None:
                curr = curr.right
            else:
                post = curr.left
                while post.right and post.right != curr:
                    post = post.right
                if post.right is None:
                    post.right = curr
                    curr = curr.right
                else:
                    post.right = None
                    curr = curr.left

def main():
    solver = Solution()

if __name__ == '__main__':
    main()
