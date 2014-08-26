#!/usr/bin/env python3

import math
from point import Point

class Solution:
    def maxPoints(self, points):
        if len(points) < 3:
            return len(points)
        res = 2
        for p in points:
            track = dict()
            same = 0
            cnt = 0
            for q in points:
                if p.x == q.x and p.y == q.y:
                    same += 1
                else:
                    angle = math.atan2(p.y - q.y, p.x - q.x)
                    track[angle] = track[angle] + 1 if angle in track else 1
                    cnt = max(cnt, track[angle])
            res = max(res, same + cnt)
        return res

def main():
    solver = Solution()

if __name__ == '__main__':
    main()
