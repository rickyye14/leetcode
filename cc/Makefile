CC = g++
DEBUG = -g
CPP0x = -std=c++0x
CFLAGS = -O2 -Wall $(DEBUG) $(CPP0x) -c
LFLAGS = -O2 -Wall
CLEANFILES = *.o

.SUFFIXES: .cc .o .bin

.cc.o:
	$(CC) $(CFLAGS) -o $@ -c $<

.o.bin:
	$(CC) $(LFLAGS) -o $@ $<

PROGS = \
		lru_cache.cc	\
		copy_list_with_random_pointer.cc	\
		surrounded_regions.cc	\
		longest_consecutive_sequence.cc	\
		binary_tree_inorder_traversal.cc	\
		wildcard_matching.cc	\
		count_and_say.cc	\
		sudoku_solver.cc	\
		valid_sudoku.cc	\
		search_insert_position.cc	\
		search_for_a_range.cc	\
		search_in_rotated_sorted_array.cc	\
		longest_valid_parentheses.cc	\
		next_permutation.cc	\
		substring_with_concatenation_of_all_words.cc	\
		divide_two_integers.cc	\
		implement_strstr.cc	\
		remove_element.cc	\
		remove_duplicates_from_sorted_array.cc	\
		reverse_nodes_in_k_group.cc	\
		swap_nodes_in_pairs.cc	\
		merge_k_sorted_lists.cc	\
		generate_parentheses.cc	\
		valid_parentheses.cc	\
		remove_nth_node_from_end_of_list.cc	\
		letter_combinations_of_a_phone_number.cc	\
		four_sum.cc	\
		three_sum_closest.cc	\
		three_sum.cc	\
		roman_to_integer.cc	\
		integer_to_roman.cc	\
		container_with_most_water.cc	\
		regular_expression_matching.cc	\
		longest_consecutive_sequence.cc	\
		integer_to_roman.cc	\
		regular_expression_matching.cc	\
		palindrome_number.cc	\
		reverse_integer.cc	\
		zigzag_conversion.cc	\
		longest_palindromic_substring.cc	\
		add_two_numbers.cc	\
		longest_substring_without_repeating_characters.cc	\
		median_of_two_sorted_arrays.cc	\
		two_sum.cc	\

.PHONY: default clean

default: bins

bins: $(PROGS:.cc=.bin)

clean:
	$(RM) $(CLEANFILES)
