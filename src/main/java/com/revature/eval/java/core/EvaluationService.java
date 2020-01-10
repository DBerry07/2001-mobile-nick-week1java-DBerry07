package com.revature.eval.java.core;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j = 0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String[] tokens = phrase.split(" ");
		String acronym = "";
		int counter = 0;
		while (counter != tokens.length) {
			String[] hyphens = tokens[counter].split("-");
			if (hyphens.length >= 2) {
				String[] newArray = Arrays.copyOf(tokens, tokens.length + hyphens.length - 1);
				tokens = newArray;
				for (int i = tokens.length - 1; i >= counter; i--) {
					tokens[i] = tokens[i - 1];
				}
				for (int i = 0; i < hyphens.length; i++) {
					tokens[counter + i] = hyphens[i];
				}
			}
			counter++;
		}
		for (String word : tokens) {
			acronym += word.charAt(0);
		}
		acronym = acronym.toUpperCase();
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			int equalSides = 3;
			int counter = 0;
			if (this.getSideOne() == this.getSideTwo()) {
				counter++;
			}
			if (this.getSideOne() == this.getSideThree()) {
				counter++;
			}
			if (this.getSideTwo() == this.getSideThree()) {
				counter++;
			}
			if (counter == equalSides) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			int equalSides = 1;
			int counter = 0;
			if (this.getSideOne() == this.getSideTwo()) {
				counter++;
			}
			if (this.getSideOne() == this.getSideThree()) {
				counter++;
			}
			if (this.getSideTwo() == this.getSideThree()) {
				counter++;
			}
			if (counter >= equalSides) {
				return true;
			} else {
				return false;
			}
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			int equalSides = 0;
			int counter = 0;
			if (this.getSideOne() == this.getSideTwo()) {
				counter++;
			}
			if (this.getSideOne() == this.getSideThree()) {
				counter++;
			}
			if (this.getSideTwo() == this.getSideThree()) {
				counter++;
			}
			if (counter == equalSides) {
				return true;
			} else {
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		int points = 0;
		char[] tokens = string.toUpperCase().toCharArray();

		for (char letter : tokens) {
			switch (letter) {

			case ('A'):
				points += 1;
				break;
			case ('B'):
				points += 3;
				break;
			case ('C'):
				points += 3;
				break;
			case ('D'):
				points += 2;
				break;
			case ('E'):
				points += 1;
				break;
			case ('F'):
				points += 4;
				break;
			case ('G'):
				points += 2;
				break;
			case ('H'):
				points += 4;
				break;
			case ('I'):
				points += 1;
				break;
			case ('J'):
				points += 8;
				break;
			case ('K'):
				points += 5;
				break;
			case ('L'):
				points += 1;
				break;
			case ('M'):
				points += 3;
				break;
			case ('N'):
				points += 1;
				break;
			case ('O'):
				points += 1;
				break;
			case ('P'):
				points += 3;
				break;
			case ('Q'):
				points += 10;
				break;
			case ('R'):
				points += 1;
				break;
			case ('S'):
				points += 1;
				break;
			case ('T'):
				points += 1;
				break;
			case ('U'):
				points += 1;
				break;
			case ('V'):
				points += 4;
				break;
			case ('W'):
				points += 4;
				break;
			case ('X'):
				points += 8;
				break;
			case ('Y'):
				points += 4;
				break;
			case ('Z'):
				points += 10;
				break;
			}
		}

		return points;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration

		char[] characters = string.toCharArray();
		StringBuilder build = new StringBuilder();
		for (char each : characters) {
			if (Character.compare(each, '0') >= 0 && Character.compare(each, '9') <= 0) {
				build.append(each);
			}
		}
		if (build.length() > 11 || build.length() < 10) {
			throw new IllegalArgumentException();
		} else {
			if (build.charAt(0) == '1') {
				build.deleteCharAt(0);
			}
		}

		String newString = build.toString();

		return newString;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration

		ArrayList<String> words = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<>();
		StringBuilder build = new StringBuilder();

		for (int i = 0; i < string.length(); i++) {
			build.append(string.charAt(i));
		}
		for (int i = 0; i < build.length(); i++) {
			if (((Character.compare(build.charAt(i), 'a') < 0 || Character.compare(build.charAt(i), 'z') > 0))
			// || (Character.compare(build.charAt(i), 'A') < 0 ||
			// Character.compare(build.charAt(i), 'Z') > 0)
			) {
				build.replace(i, i + 1, " ");
				// System.out.println(build);
			}
		}
		String str = build.toString();
		String[] tokens = str.split(" ");

		for (String word : tokens) {
			if (map.containsKey(word) == false) {
				if (word.length() == 0) {
					continue;
				}
				map.put(word, 1);
			} else {
				map.replace(word, map.get(word) + 1);
			}
		}

		return map;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int middle = sortedList.size() / 2;
			int max_increment = sortedList.size();
			// System.out.println(sortedList.get(middle).hashCode());
			// System.out.println(t.hashCode());
			while (!sortedList.get(middle).equals(t)) {
				// System.out.println(middle);
				if (sortedList.get(middle).hashCode() > t.hashCode()) {
					if (middle == 1) {
						middle = 0;
					}
					int increment = (int) Math.floor(middle / 2);
					if (increment > max_increment) {
						increment = max_increment;
					} else {
						max_increment = increment;
					}
					middle = middle - increment;
				} else if (sortedList.get(middle).hashCode() < t.hashCode()) {
					int increment = (int) Math.floor(middle / 2);
					if (increment > max_increment) {
						increment = max_increment;
					} else {
						max_increment = increment;
					}
					middle = middle + increment;
				} else {
					return middle;
				}
				if (middle >= sortedList.size()) {
					middle = sortedList.size() - 1;
				} else if (middle < 0) {
					middle = 0;
				}
			}
			return middle;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		ArrayList<StringBuilder> builders = new ArrayList<StringBuilder>();
		String[] words = string.split(" ");
		for (String word : words) {
			StringBuilder normalWord = new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				normalWord.append(word.charAt(i));
			}
			builders.add(normalWord);
		}
		// System.out.println(builders);

		for (StringBuilder build : builders) {
			while (build.charAt(0) != 'a' && build.charAt(0) != 'e' && build.charAt(0) != 'i' && build.charAt(0) != 'o'
					&& build.charAt(0) != 'u') {
				build.append(build.charAt(0));
				build.delete(0, 1);
			}
			while (build.charAt(1) == 'a' || build.charAt(1) == 'e' || build.charAt(1) == 'i' || build.charAt(1) == 'o'
					|| build.charAt(1) == 'u') {
				if (build.charAt(1) == build.charAt(0)) {
					break;
				}
				build.append(build.charAt(0));
				build.delete(0, 1);
			}
			build.append("ay");
		}
		String str = "";
		for (StringBuilder build : builders) {
			str += build.toString() + " ";
		}
		str = str.trim();
		// System.out.println(build);
		return str;

	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		int total = 0;
		int length = Integer.toString(input).length();
		char[] digits = Integer.toString(input).toCharArray();
		for (char digit : digits) {
			int value = Character.getNumericValue(digit);
			total += (int) Math.pow(value, length);
		}
		if (total == input) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	
	/*
	 * testProductOfPrimes CAN TAKE UP TO 2 MINUTES!
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> numbers = new ArrayList<Long>();
		List<Long> primes = new ArrayList<Long>();
		// primes.add(2L);
		//List<Long> temp = Arrays.asList(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L);
		//primes.addAll(temp);
		List<Long> factors = new ArrayList<Long>();
		long remainder = l;
		int counter = 0;
		{
			for (long i = 2; i <= l; i++) {
				numbers.add(i);
			}
			
			Iterator<Long> iter = numbers.iterator();
			for (int i = 0; i < numbers.size(); i++) {
				if (numbers.get(i) == 0) {
					continue;
				}
				for (int j = i + 1; j < numbers.size() - 1; j++) {
					if (numbers.get(j) == 0) {
						continue;
					}
					boolean not = numbers.get(j) >= (long) Math.pow(numbers.get(i), 2);
					boolean yes = numbers.get(j) % numbers.get(i) == 0L;
					//System.out.println(not + " " + yes);
					//System.out.println(numbers.get(j));
					//System.out.println((long) Math.pow(numbers.get(i), 2));
					if (numbers.get(j) >= (long) Math.pow(numbers.get(i), 2) && numbers.get(j) % numbers.get(i) == 0L) {
						numbers.set(j, 0L);
						//System.out.println("Zeroed");
					}
				}
			}
			
			while (iter.hasNext()) {
				if (iter.next() == 0L) {
					iter.remove();
				}
			}
			
			//System.out.println(numbers);
			primes = numbers;
			
		}
		
		
		/*
		 * for (long i = 3; i < l; i++) { if (i % 10000L == 0) {
		 * System.out.println("Still Running " + counter); counter++; } for (long j = i
		 * - 1L; j > 1; j--) { if (i % j == 0) { break; } else if (j == 2){
		 * primes.add(i); } } } counter = 0;
		 */
		do {
			for (long prime : primes) {
				if (remainder % prime == 0) {
					remainder = remainder / prime;
					factors.add((long) prime);
					break;
				}
				counter++;
			}
			if (counter == primes.size()) {
				primes.add(remainder);
			}
			counter = 0;
		} while (remainder != 1);

		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			char[] characters = string.toCharArray();
			StringBuilder builder = new StringBuilder();

			for (char letter : characters) {
				if ((int) letter >= (int) 'a' && (int) letter <= (int) 'z') {
					int val = (char) ((int) letter + key);
					if (val > (int) 'z') {
						val -= 26;
					}
					letter = (char) val;
					// System.out.println(letter);
				} else if ((int) letter >= (int) 'A' && (int) letter <= (int) 'Z') {
					int val = (char) ((int) letter + key);
					if (val > (int) 'Z') {
						val -= 26;
					}
					letter = (char) val;
				}
				builder.append(letter);
			}

			return builder.toString();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {

		// **NOTE** testBigPrime CAN TAKE UP TO A MINUTE TO COMPLETE

		ArrayList<Integer> primes = new ArrayList<Integer>();

		if (i <= 0) {
			throw new IllegalArgumentException();
		}

		int number = 2;
		int divisor;
		while (primes.size() != i) {
			divisor = number - 1;
			while (divisor >= 2) {
				if (divisor == 1) {
					break;
				}
				if (number % divisor == 0) {
					break;
				}
				divisor--;
			}
			if (divisor == 1) {
				primes.add(number);
			}
			number++;
		}

		return primes.get(i - 1);
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration

			char[] letters = string.toCharArray();
			int counter = 0;
			char space = ' ';

			StringBuilder builder = new StringBuilder();
			int spaces = 0;

			for (char letter : letters) {
				if (counter == 5 && (((int) letter >= (int) 'a' && (int) letter <= (int) 'z')
						|| ((int) letter >= (int) 'A' && (int) letter <= (int) 'Z'))) {
					builder.append(space);
					counter = 0;
				}
				if (Character.isDigit(letter) == true) {
					builder.append(letter);
					counter++;
				}

				else if ((int) letter >= (int) 'a' && (int) letter <= (int) 'z') {
					spaces = (int) letter - (int) 'a';
					char encoded = (char) ((int) 'z' - spaces);
					builder.append(encoded);
					counter++;
				} else if ((int) letter >= (int) 'A' && (int) letter <= (int) 'Z') {
					spaces = (int) letter - (int) 'A';
					char encoded = (char) ((int) 'z' - spaces);
					builder.append(encoded);
					counter++;
				}
			}

			return builder.toString();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			StringBuilder builder = new StringBuilder();
			char[] letters = string.toCharArray();
			int spaces = 0;

			for (char letter : letters) {
				if (Character.isDigit(letter) == true) {
					builder.append(letter);
				}

				else if ((int) letter >= (int) 'a' && (int) letter <= (int) 'z') {
					spaces = (int) letter - (int) 'a';
					char encoded = (char) ((int) 'z' - spaces);
					builder.append(encoded);
				} else if ((int) letter >= (int) 'A' && (int) letter <= (int) 'Z') {
					spaces = (int) letter - (int) 'A';
					char encoded = (char) ((int) 'z' - spaces);
					builder.append(encoded);
				}
			}
			return builder.toString();
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration

		char[] characters = string.toCharArray();
		List<Integer> digits = new LinkedList<Integer>();
		int multiplier = 10;
		int product = 0;
		for (char character : characters) {
			if (digits.size() == 9 && character == 'X') {
				digits.add(10);
			} else if (Character.isDigit(character) == true) {
				digits.add(Character.getNumericValue(character));
			}

		}
		for (int digit : digits) {
			product = product + (digit * multiplier);
			multiplier--;
		}

		if (digits.size() == 10 && product % 11 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (pan gramma, "every
	 * letter") is a sentence using every letter of the alphabet at least once. The
	 * best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		int[] alphabetCheck = new int[26];
		char[] characters = string.toLowerCase().toCharArray();
		int index = -1;
		for (char letter : characters) {
			if ((int) letter >= (int) 'a' && (int) letter <= (int) 'z') {
				index = (int) letter - (int) 'a';
				alphabetCheck[index] = 1;
			}
		}
		for (int check : alphabetCheck) {
			if (check != 1) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		long gigasecond = (long) Math.pow(10, 9);
		Temporal lived = given;
		Duration days = Duration.ofDays(gigasecond);
		if (!given.isSupported(ChronoField.SECOND_OF_DAY)) {
			LocalDateTime converted = ((LocalDate) given).atStartOfDay();
			lived = converted.plus(gigasecond, ChronoUnit.SECONDS);
		} else {
			LocalDateTime converted = (LocalDateTime) given;
			lived = converted.plus(gigasecond, ChronoUnit.SECONDS);
		}
		return lived;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration

		Set<Integer> multiples = new HashSet<Integer>();
		int total = 0;

		for (int each : set) {
			int multi = each;
			while (multi < i) {
				multiples.add(multi);
				multi = multi + each;
			}
		}

		for (int each : multiples) {
			total += each;
		}

		return total;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration

		char[] array = string.toCharArray();
		List<Integer> numbers = new ArrayList<Integer>();

		for (char number : array) {
			if (Character.isDigit(number)) {
				numbers.add(Character.getNumericValue(number));
			} else if (!Character.isDigit(number) && number != ' ') {
				return false;
			}
		}

		int place = numbers.size() - 2;
		int total = 0;

		while (place >= 0) {
			numbers.set(place, numbers.get(place) * 2);
			if (numbers.get(place) > 9) {
				numbers.set(place, numbers.get(place) - 9);
			}
			place -= 2;
		}

		for (int each : numbers) {
			total += each;
		}

		if (total % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration

		String[] parsed = string.split(" ");
		List<Integer> values = new ArrayList<Integer>();
		String operation = "";
		int answer = 0;

		for (String each : parsed) {
			each = each.replace("?", "");
			try {
				values.add(Integer.parseInt(each));
			} catch (Exception e) {
				System.out.println("Not an integer");
			}
			if (each.contains("divided")) {
				operation = "/";
			} else if (each.contains("multiplied")) {
				operation = "*";
			} else if (each.contains("plus")) {
				operation = "+";
			} else if (each.contains("minus")) {
				operation = "-";
			}
		}

		{
			if (operation == "-") {
				answer = values.get(0) - values.get(1);
			} else if (operation == "+") {
				answer = values.get(0) + values.get(1);
			} else if (operation == "/") {
				answer = values.get(0) / values.get(1);
			} else if (operation == "*") {
				answer = values.get(0) * values.get(1);
			}
		}

		return answer;
	}

}
