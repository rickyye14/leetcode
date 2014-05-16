JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  ListNode.java \
		  GenerateParentheses.java \
		  RemoveNthNodeFromEndOfList.java \
		  LetterCombinationsOfAPhoneNumber.java \
		  FourSum.java \
		  ThreeSumClosest.java \
		  ThreeSum.java \
		  IntegerToRoman.java \
		  ContainerWithMostWater.java \
		  RegularExpressionMatching.java \
		  PalindromeNumber.java \
		  StringToInteger.java \
		  ReverseInteger.java \
		  ZigZagConversion.java \
		  LongestPalindromicSubstring.java \
		  AddTwoNumbers.java \
		  LongestSubstringWithoutRepeatingCharacters.java \
		  MedianOfTwoSortedArrays.java \
		  TwoSum.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
