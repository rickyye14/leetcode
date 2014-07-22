CC = g++
DEBUG = -g
C11 = -std=c++0x
CFLAGS = -O2 -Wall $(DEBUG) $(C11) -c
LFLAGS = -O2 -Wall
CLEANFILES = *.o

PROGS = \
		longest_palindromic_substring	\
		add_two_numbers	\
		longest_substring_without_repeating_characters	\
		median_of_two_sorted_arrays	\
		two_sum	\

.PHONY: clean

all:	$(PROGS)

longest_palindromic_substring: longest_palindromic_substring.o
	$(CC) $(LFLAGS) -o $@ $<

longest_palindromic_substring.o: longest_palindromic_substring.cc
	$(CC) $(LFLAGS) -o $@ -c $<

add_two_numbers: add_two_numbers.o
	$(CC) $(LFLAGS) -o $@ $<

add_two_numbers.o: add_two_numbers.cc
	$(CC) $(LFLAGS) -o $@ -c $<

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
