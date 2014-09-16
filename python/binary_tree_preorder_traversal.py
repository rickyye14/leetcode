#!/usr/bin/env python3

from tree_node import TreeNode

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def preorderTraversal(self, root):
        res = list()
        curr = root
        while curr:
            if curr.left is None:
                res.append(curr.val)
                curr = curr.right
            else:
                post = curr.left
                while post.right and post.right != curr:
                    post = post.right
                if post.right == curr:
                    post.right = None
                    curr = curr.right
                else:
                    res.append(curr.val)
                    post.right = curr
                    curr = curr.left
        return res

def main():
    solver = Solution()

if __name__ == '__main__':
    main()
