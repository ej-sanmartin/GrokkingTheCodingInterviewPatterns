/*
  T - O(n + m), looping through both passed strings once each
  S - O(p), where HashMap is determined by the number of unique characters in the pattern string

  Given a string and a pattern, find out if the string contains any permutation of the pattern.
*/

import java.util.*;

class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    HashMap<Character, Integer> characterInPatternFrequency = new HashMap<Character, Integer>();
    int startPointer = 0, match = 0;

    for(int i = 0; i < pattern.length(); i++){
      char currentCharInPattern = pattern.charAt(i);
      characterInPatternFrequency.put(currentCharInPattern, characterInPatternFrequency.getOrDefault(currentCharInPattern, 0) + 1);
    }

    for(int endPointer = 0; endPointer < str.length() - 1; endPointer++){
      char currentChar = str.charAt(endPointer);
      if(characterInPatternFrequency.containsKey(currentChar)){
        characterInPatternFrequency.put(currentChar, characterInPatternFrequency.get(currentChar) - 1);
        match++;
      }

      if(characterInPatternFrequency.size() == match){ return true; }

      if(endPointer >= pattern.length() - 1){
        char startPointerCharacter = str.charAt(startPointer);
        if(characterInPatternFrequency.containsKey(startPointerCharacter)){
          if(characterInPatternFrequency.get(startPointerCharacter) == 0){
            match--;
          }
          characterInPatternFrequency.put(startPointerCharacter, characterInPatternFrequency.getOrDefault(startPointerCharacter, 0) + 1);

        }
        startPointer++;
      }
    }
    return false;
  }
}
