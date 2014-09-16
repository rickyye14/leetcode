#!/usr/bin/env python3

class Solution:
    def isDigits(self, s):
        for c in s:
            if c not in '0123456789':
                return False
        return True

    def isNumberWithoutExponet(self, s, decimal = False):
        if not s:
            return False
        if s[0] == '-' or s[0] == '+':
            s = s[1:]
        if '.' in s:
            if not decimal:
                return False
            parts = s.split('.')
            if len(parts) != 2 or not parts[0] and not parts[1]:
                return False
            return self.isDigits(parts[0]) and self.isDigits(parts[1])
        return len(s) != 0 and self.isDigits(s)

    # @param s, a string
    # @return a boolean
    def isNumber(self, s):
        s = s.strip()
        if 'e' in s:
            nums = s.split('e')
            return len(nums) == 2 \
                    and self.isNumberWithoutExponet(nums[0], True) \
                    and self.isNumberWithoutExponet(nums[1], False)
        elif 'E' in s:
            nums = s.split('E')
            return len(nums) == 2 \
                    and self.isNumberWithoutExponet(nums[0], True) \
                    and self.isNumberWithoutExponet(nums[1], False)
        else:
            return self.isNumberWithoutExponet(s, True)

def main():
    solver = Solution()
    print(solver.isNumber('0'))
    print(solver.isNumber(' 0.1'))
    print(solver.isNumber('abc'))
    print(solver.isNumber('1 a'))
    print(solver.isNumber('2e10'))

if __name__ == '__main__':
    main()
