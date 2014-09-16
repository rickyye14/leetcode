#!/usr/bin/env python3

import collections

class Solution:
    # @param start, a string
    # @param end, a string
    # @param dict, a set of string
    # @return an integer
    def ladderLength(self, start, end, dict):
        if start in dict:
            dict.remove(start)
        dict.add(end)
        if len(start) != len(end):
            return 0
        queue = collections.deque([start])
        m = len(start)
        dist = {start: 0}
        while queue:
            curr = queue.popleft()
            if curr == end:
                return dist[curr] + 1
            curr_list = list(curr)
            for i in range(m):
                head = curr[:i]
                tail = curr[i + 1:]
                for ch in 'abcdefghijklmnopqrstuvwxyz':
                    if curr[i] == ch:
                        continue
                    post = head + ch + tail
                    if post not in dict:
                        continue
                    if post not in dist or post in dist and dist[post] > dist[curr] + 1:
                        dist[post] = dist[curr] + 1
                        queue.append(post)
        return 0

def main():
    solver = Solution()
    start = 'hit'
    end = 'cog'
    dict = {'hot', 'dot', 'dog', 'lot', 'log'}
    print(solver.ladderLength(start, end, dict))

if __name__ == '__main__':
    main()
