#!/usr/bin/env python3

class Solution:
    # @param intervals, a list of Interval
    # @return a list of Interval
    def merge(self, intervals):
        if intervals is None or not intervals:
            return intervals
        n = len(intervals)
        res = list()
        intervals = sorted(intervals, key=lambda interval: interval.start)
        l = intervals[0].start
        r = intervals[0].end
        for i in range(1, n):
            if intervals[i].start <= r:
                r = max(r, intervals[i].end)
            else:
                res.append(Interval(l, r))
                l = intervals[i].start
                r = intervals[i].end
        res.append(Interval(l, r))
        return res

def main():
    solver = Solution()

if __name__ == '__main__':
    main()
