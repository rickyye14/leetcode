#!/usr/bin/env python3

from tree_node import TreeNode

class Solution:
    def __init__(self):
        self.max_sum = -0x3f3f3f3f
    # @param root, a tree node
    # @return an integer
    def maxPathSum(self, root):
        self.helper(root)
        return self.max_sum

    def helper(self, node):
        if not node:
            return 0
        left_sum = self.helper(node.left)
        right_sum = self.helper(node.right)
        t = node.val + max(0, left_sum) + max(0, right_sum)
        if t > self.max_sum:
            self.max_sum = t
        return node.val + max(0, left_sum, right_sum)

def main():
    solver = Solution()

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.left.left = TreeNode(3)
    print(solver.maxPathSum(root))

if __name__ == '__main__':
    main()
