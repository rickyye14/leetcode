JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
		  LongestSubstringWithoutRepeatingCharacters.java \
		  MedianOfTwoSortedArrays.java \
		  TwoSum.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
