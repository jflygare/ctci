#include <iostream>

static inline void reverse(char* str) {
	// str is just a pointer to the starting location of an array of bytes (char) in memory
	// Can only iterate through the array until we see a null terminator '\0'
	// <string.h> provides utilities for working with strings (null terminated char arrays)
	std::cout << "The input string = [" << str << "]" << std::endl;
	int i = 0;
	while (str[i] != '\0') { i++; }
	std::cout << "The string is [" << i << "] chars" << std::endl;
	// Swap the values in place, in memory
	// Only need to iterate through half the array since letters are trading
	int j = 0;
	int k = i - 1; // For readability
	char tmp = '\0';
	while (j < k) {
		std::cout << "Swapping [" << str[j] << "] with [" << str[k] << "]" << std::endl;
		tmp = str[j];
		str[j] = str[k];
		str[k] = tmp;
		j++; k--;
	}
	std::cout << "The string is now = [" << str << "]" << std::endl;
}
