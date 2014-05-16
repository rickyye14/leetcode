JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  GenerateParentheses.java \
		  ThreeSum.java \
		  LongestCommonPrefix.java \
		  RomanToInteger.java \
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
