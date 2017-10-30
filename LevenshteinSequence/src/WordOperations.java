import java.util.*;

public class WordOperations extends Dictionary {
	// you put extends in the superclass not the subclass. ugh
	
	// Helper Function for computeDistance
	// Finds the minimum distance for Levenshtein distance
	public int minimum(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	// checks interim steps for distance
	// the distance must be 1
	public int computeDistance(String leftWord, String rightWord) {
		// create two dimensional array
		int[][] distance = new int[leftWord.length() + 1][rightWord.length() + 1];

		// create the first row and column in the 2d array
		for (int i = 0; i <= leftWord.length(); i++) {
			distance[i][0] = i;
		}
		for (int j = 0; j <= rightWord.length(); j++) {
			distance[0][j] = j;
		}

		// populate the 2d array
		for (int i = 1; i <= leftWord.length(); i++) {
			for (int j = 1; j <= rightWord.length(); j++) {
				distance[i][j] = minimum(distance[i - 1][j] + 1, distance[i][j - 1] + 1,
						distance[i - 1][j - 1] + ((leftWord.charAt(i - 1) == rightWord.charAt(j - 1)) ? 0 : 1));
			}
		}
		// return the amount of changes needed to get the right word from the left word
		return distance[leftWord.length()][rightWord.length()];
	}
	
	
	// takes the current word and the position to be removed
	// returns the new string
	// ex: deleteLetter("team", 3); -> "tea"
	// s is the current word and p is the position to be removed
	public String deleteLetter(String s, int p) {
		char[] wordCharArray = s.toCharArray();
		int newWordLength = wordCharArray.length + 1;
		char[] newCharArray = new char[newWordLength];
		ArrayList<Character> newWord = new ArrayList<Character>();
		// recursively add letters from old array to new arraylist
		for (int i = 0; i < wordCharArray.length; i++) {
			newWord.add(i, wordCharArray[i]);
		}
		newWord.remove(p);
		// and clear original array
		// convert ArrayList back to char[]
		for (int j = 0; j < newWord.size(); j++) {
			newCharArray[j] = newWord.get(j);
		}
		
		return String.valueOf(newCharArray);
	}
	
	// input: String to change, Position, and character to add
	// p is the position that the letter would be inserted after
	// ex: addLetter("rad", 2, 'i'); -> "raid"
	public String addLetter(String s, int p, char c) {
		char[] wordCharArray = s.toCharArray();
		int newWordLength = wordCharArray.length + 1;
		char[] newCharArray = new char[newWordLength];
		ArrayList<Character> newWord = new ArrayList<Character>();
		// recursively add letters from old array to new arraylist
		for (int i = 0; i < wordCharArray.length; i++) {
			newWord.add(i, wordCharArray[i]);
		}
		newWord.add(p, c);
		// and clear original array
		// convert ArrayList back to char[]
		for (int j = 0; j < newWord.size(); j++) {
			newCharArray[j] = newWord.get(j);
		}
		
		return String.valueOf(newCharArray);
	}
	
	// input: String to change, Position to change, and letter to change it to
	// output: new String/String
	// ex: replaceLetter("tips", 1, 'a'); -> "taps"
	public String replaceLetter(String s, int p, char c) {
		char[] wordCharArray = s.toCharArray();
		System.out.println(wordCharArray);
		wordCharArray[p] = c;
		System.out.println(String.valueOf(wordCharArray));
		return String.valueOf(wordCharArray);
	}
	
	// takes the current string and checks it with a dictionary.
	// returns whether or not the current string is actually a word (true/false)
	// I will attempt to use a trie-based dictionary due to possible speed constraints.
	// ex: isWord("trope"); -> true;
	public boolean isWord(String s) {
		ArrayList<String> dict = new ArrayList<String>();
		dict = super.createDictionary();
		if (dict.contains(s)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isGreaterThanThree(String s) {
		if (s.length() >= 3) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isAnagram(String a, String b) {
		// base case - if the strings aren't the same amount of letters
		// they are automatically not anagrams
		if (a.length() != b.length()) {
			return false;
		}
		// convert strings to character arrays
		char[] aArray = a.replaceAll("[\\s]", "").toCharArray();
		char[] bArray = b.replaceAll("[\\s]", "").toCharArray();
		// check if there are the same letters in the words
		// first by sorting the two char arrays
		Arrays.sort(aArray);
		Arrays.sort(bArray);
		// finally by returning whether or not they equal
		return Arrays.equals(aArray, bArray);
	}
}
