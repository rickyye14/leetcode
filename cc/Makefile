CC = g++
DEBUG = -g
CPP0x = -std=c++0x
CFLAGS = -O2 -Wall $(DEBUG) $(CPP0x) -c
LFLAGS = -O2 -Wall
CLEANFILES = *.o

PROGS = \
		longest_consecutive_sequence	\
		swap_nodes_in_pairs	\
		merge_k_sorted_lists	\
		generate_parentheses	\
		valid_parentheses	\
		remove_nth_node_from_end_of_list	\
		letter_combinations_of_a_phone_number	\
		four_sum	\
		three_sum_closest	\
		three_sum	\
		roman_to_integer	\
		integer_to_roman	\
		container_with_most_water	\
		regular_expression_matching	\
		longest_consecutive_sequence	\
		integer_to_roman	\
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

surrounded_regions: surrounded_regions.o
	$(CC) $(LFLAGS) -o $@ $<

surrounded_regions.o: surrounded_regions.cc
	$(CC) $(CFLAGS) -o $@ -c $<

longest_consecutive_sequence: longest_consecutive_sequence.o
	$(CC) $(LFLAGS) -o $@ $<

longest_consecutive_sequence.o: longest_consecutive_sequence.cc
	$(CC) $(CFLAGS) -o $@ -c $<

swap_nodes_in_pairs: swap_nodes_in_pairs.o
	$(CC) $(LFLAGS) -o $@ $<

swap_nodes_in_pairs.o: swap_nodes_in_pairs.cc
	$(CC) $(CFLAGS) -o $@ -c $<

merge_k_sorted_lists: merge_k_sorted_lists.o
	$(CC) $(LFLAGS) -o $@ $<

merge_k_sorted_lists.o: merge_k_sorted_lists.cc
	$(CC) $(CFLAGS) -o $@ -c $<

generate_parentheses: generate_parentheses.o
	$(CC) $(LFLAGS) -o $@ $<

generate_parentheses.o: generate_parentheses.cc
	$(CC) $(CFLAGS) -o $@ -c $<

valid_parentheses: valid_parentheses.o
	$(CC) $(LFLAGS) -o $@ $<

valid_parentheses.o: valid_parentheses.cc
	$(CC) $(CFLAGS) -o $@ -c $<

remove_nth_node_from_end_of_list: remove_nth_node_from_end_of_list.o
	$(CC) $(LFLAGS) -o $@ $<

remove_nth_node_from_end_of_list.o: remove_nth_node_from_end_of_list.cc
	$(CC) $(CFLAGS) -o $@ -c $<

letter_combinations_of_a_phone_number: letter_combinations_of_a_phone_number.o
	$(CC) $(LFLAGS) -o $@ $<

letter_combinations_of_a_phone_number.o: letter_combinations_of_a_phone_number.cc
	$(CC) $(CFLAGS) -o $@ -c $<

four_sum: four_sum.o
	$(CC) $(LFLAGS) -o $@ $<

four_sum.o: four_sum.cc
	$(CC) $(CFLAGS) -o $@ -c $<

three_sum_closest: three_sum_closest.o
	$(CC) $(LFLAGS) -o $@ $<

three_sum_closest.o: three_sum_closest.cc
	$(CC) $(CFLAGS) -o $@ -c $<

three_sum: three_sum.o
	$(CC) $(LFLAGS) -o $@ $<

three_sum.o: three_sum.cc
	$(CC) $(CFLAGS) -o $@ -c $<

roman_to_integer: roman_to_integer.o
	$(CC) $(LFLAGS) -o $@ $<

roman_to_integer.o: roman_to_integer.cc
	$(CC) $(CFLAGS) -o $@ -c $<

integer_to_roman: integer_to_roman.o
	$(CC) $(LFLAGS) -o $@ $<

integer_to_roman.o: integer_to_roman.cc
	$(CC) $(CFLAGS) -o $@ -c $<

container_with_most_water: container_with_most_water.o
	$(CC) $(LFLAGS) -o $@ $<

container_with_most_water.o: container_with_most_water.cc
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
