#!/usr/bin/env python3

class Solution:
    # @param tokens, a list of string
    # @return an integer
    def evalRPN(self, tokens):
        nums = list()
        for t in tokens:
            if t not in '+-/*':
                nums.append(int(t))
            else:
                if t == '+':
                    nums[-2] += nums[-1]
                elif t == '-':
                    nums[-2] -= nums[-1]
                elif t == '*':
                    nums[-2] *= nums[-1]
                else:
                    if nums[-2] > 0 and nums[-1] > 0 or nums[-2] < 0 and nums[-1] < 0:
                        nums[-2] = abs(nums[-2]) // abs(nums[-1])
                    else:
                        nums[-2] = -(abs(nums[-2]) // abs(nums[-1]))
                nums.pop()
        return nums[0]

def main():
    solver = Solution()
    print(solver.evalRPN(["2", "1", "+", "3", "*"]))
    print(solver.evalRPN(["4", "13", "5", "/", "+"]))
    print(solver.evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"]))

if __name__ == '__main__':
    main()
