/*
  T - O(n^2) because despite looping through string once, there is a chance we have to clear all our data from set using clear method which itself is O(n)
  S - O(k) because k is the amount of distinct characters than can be added to set.
  Given a string, find the length of the longest substring which has no repeating characters.
*/

import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    HashSet<Character> distinctCharacter = new HashSet<Character>();
    int startWindow = 0;
    int maxLength = 0;

    for(int i = 0; i < str.length(); i++){
      char currentChar = str.charAt(i);
      if(distinctCharacter.contains(currentChar)){
        distinctCharacter.clear();
        distinctCharacter.add(currentChar);
        startWindow = i;
      } else {
        distinctCharacter.add(currentChar);
      }

      maxLength = Math.max(maxLength, i - startWindow + 1);
    }

    return maxLength;
  }
