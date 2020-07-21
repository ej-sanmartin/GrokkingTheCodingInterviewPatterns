/*
  T - O(n + m)
  S - O(p)
  
  Given a string and a pattern, find all anagrams of the pattern in the given string.
  Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
*/

import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    HashMap<Character, Integer> patternLettersFrequency = new HashMap<Character, Integer>();
    int match = 0, startPointer = 0;

    for(int i = 0; i < pattern.length(); i++){
      patternLettersFrequency.put(pattern.charAt(i), patternLettersFrequency.getOrDefault(pattern.charAt(i), 0) + 1);
    }

    for(int endPointer = 0; endPointer < str.length(); endPointer++){
      char currentChar = str.charAt(endPointer);
      if(patternLettersFrequency.containsKey(currentChar)){
        patternLettersFrequency.put(currentChar, patternLettersFrequency.get(currentChar) - 1);
        if(patternLettersFrequency.get(currentChar) == 0){
          match++;
        }
      }

      if(match == patternLettersFrequency.size()){
        resultIndices.add(startPointer);
      }
        
      if(endPointer >= pattern.length() - 1){
        char startChar = str.charAt(startPointer);
        if(patternLettersFrequency.containsKey(startChar)){
          if(patternLettersFrequency.get(startChar) == 0){
            match--;
          } 
          patternLettersFrequency.put(startChar, patternLettersFrequency.get(startChar) + 1);
        }
        startPointer++;
      }
    }

    return resultIndices;
  }
}
