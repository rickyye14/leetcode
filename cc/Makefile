CC = g++
DEBUG = -g
CPP0x = -std=c++0x
CFLAGS = -O2 -Wall $(DEBUG) $(CPP0x) -c
LFLAGS = -O2 -Wall
CLEANFILES = *.o

PROGS = \
		longest_consecutive_sequence	\
		regular_expression_matching	\
		palindrome_number	\
		reverse_integer	\
		zigzag_conversion	\
		longest_palindromic_substring	\
		add_two_numbers	\
		longest_substring_without_repeating_characters	\
		median_of_two_sorted_arrays	\
		two_sum	\

.PHONY: clean

all:	$(PROGS)

longest_consecutive_sequence: longest_consecutive_sequence.o
	$(CC) $(LFLAGS) -o $@ $<

longest_consecutive_sequence.o: longest_consecutive_sequence.cc
	$(CC) $(CFLAGS) -o $@ -c $<

regular_expression_matching: regular_expression_matching.o
	$(CC) $(LFLAGS) -o $@ $<

regular_expression_matching.o: regular_expression_matching.cc
	$(CC) $(CFLAGS) -o $@ -c $<

palindrome_number: palindrome_number.o
	$(CC) $(LFLAGS) -o $@ $<

palindrome_number.o: palindrome_number.cc
	$(CC) $(CFLAGS) -o $@ -c $<

reverse_integer: reverse_integer.o
	$(CC) $(LFLAGS) -o $@ $<

reverse_integer.o: reverse_integer.cc
	$(CC) $(CFLAGS) -o $@ -c $<

zigzag_conversion: zigzag_conversion.o
	$(CC) $(LFLAGS) -o $@ $<

zigzag_conversion.o: zigzag_conversion.cc
	$(CC) $(CFLAGS) -o $@ -c $<

longest_palindromic_substring: longest_palindromic_substring.o
	$(CC) $(LFLAGS) -o $@ $<

longest_palindromic_substring.o: longest_palindromic_substring.cc
	$(CC) $(CFLAGS) -o $@ -c $<

add_two_numbers: add_two_numbers.o
	$(CC) $(LFLAGS) -o $@ $<

add_two_numbers.o: add_two_numbers.cc
	$(CC) $(CFLAGS) -o $@ -c $<

longest_substring_without_repeating_characters: longest_substring_without_repeating_characters.o
	$(CC) $(LFLAGS) -o $@ $<

longest_substring_without_repeating_characters.o: longest_substring_without_repeating_characters.cc
	$(CC) $(CFLAGS) -o $@ -c $<

median_of_two_sorted_arrays: median_of_two_sorted_arrays.o
	$(CC) $(LFLAGS) -o $@ $<

median_of_two_sorted_arrays.o: median_of_two_sorted_arrays.cc
	$(CC) $(CFLAGS) -o $@ -c $<

two_sum: two_sum.o
	$(CC) $(LFLAGS) -o $@ $<

two_sum.o: two_sum.cc
	$(CC) $(CFLAGS) -o $@ -c $<

clean:
	$(RM) $(PROGS) $(CLEANFILES)
