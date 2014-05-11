JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  LongestPalindromicSubstring.java \
		  AddTwoNumbers.java \
		  LongestSubstringWithoutRepeatingCharacters.java \
		  MedianOfTwoSortedArrays.java \
		  TwoSum.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
