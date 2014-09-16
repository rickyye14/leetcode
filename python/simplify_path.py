#!/usr/bin/env python3

class Solution:
    # @param path, a string
    # @return a string
    def simplifyPath(self, path):
        tokens = path.split('/')
        stack = list()
        for t in tokens:
            if not t or t == '.':
                continue
            if t == '..':
                if stack:
                    stack.pop()
            else:
                stack.append(t)
        return '/' + '/'.join(stack)

def main():
    solver = Solution()
    print(solver.simplifyPath('/a/./b/../../c/'))

if __name__ == '__main__':
    main()
