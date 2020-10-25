package maps;

import java.util.*;

//https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
public class MakeAnagrams {
	static public int makeAnagrams(String a, String b) {
		int deletions = 0;
		final Map<Character, Integer> mapA = new HashMap<Character, Integer>();
		final Map<Character, Integer> mapB = new HashMap<Character, Integer>();
		
		// fill mapA with character counts
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			int count = mapA.containsKey(c) ? mapA.get(c) : 1;
			mapA.put(c, count);
		}
		
		// fill mapB with character counts as well as looking for characters
		// in 'b' that don't exist in 'a'
		for (int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			int count = mapB.containsKey(c) ? mapB.get(c) : 1;
			mapB.put(c, count);
			// if MapA does not have the char then we would need to delete
			// this char so increment deletions
			if (!mapA.containsKey(c)) {
				deletions++;
				continue;
			}
			// There is a match so decrement mapA count
			mapA.put(c, mapA.get(c) - 1);
		}
		
		// Go back through mapA to look for characters that don't exist in b
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (!mapB.containsKey(c)) {
				deletions++;
				continue;
			}
			// There is a match so decrement mapA count
			mapB.put(c, mapB.get(c) - 1);
		}
		return deletions;
	}

}
