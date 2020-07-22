/*
  T - O(n + m),  looping length of pattern and then length of str
  S - O(P), however many distinct characters in pattern that will be kept track in HashMap
  
  Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.
*/

import java.util.*;

class MinimumWindowSubstring {
  public static String findSubstring(String str, String pattern) {
    int match = 0, startPointer = 0, startSubString = 0;
    int smallestSubArrayLength = str.length() + 1;
    HashMap<Character, Integer> patternLettersFrequency = new HashMap<Character, Integer>();

    for(int i = 0; i < pattern.length(); i++){
      patternLettersFrequency.put(pattern.charAt(i), patternLettersFrequency.getOrDefault(pattern.charAt(i), 0) + 1);
    }

    for(int endPointer = 0; endPointer < str.length(); endPointer++){
      char currentChar = str.charAt(endPointer);
      if(patternLettersFrequency.containsKey(currentChar)){
        patternLettersFrequency.put(currentChar, patternLettersFrequency.get(currentChar) - 1);
        if(patternLettersFrequency.get(currentChar) >= 0){
          match++;
        }
      }

      while(match == pattern.length()) {
        if(smallestSubArrayLength > endPointer - startPointer + 1){
          smallestSubArrayLength = endPointer - startPointer + 1;
          startSubString = startPointer;
        }

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
    
    return smallestSubArrayLength > str.length() ? "" : str.substring(startSubString, startSubString + smallestSubArrayLength);
  }
}
