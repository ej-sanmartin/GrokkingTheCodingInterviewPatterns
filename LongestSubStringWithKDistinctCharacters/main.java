/*
  T - O(n) | S - O(k)
*/

import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    if (str == null || str.length() == 0 || str.length() < k){ throw new IllegalArgumentException(); }

    HashMap<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
    int startPointer = 0;
    int maxCount = 0;

    for(int i = 0; i < str.length(); i++){
      char currentChar = str.charAt(i);
      frequencyMap.put(currentChar, frequencyMap.getOrDefault(currentChar, 0) + 1);

      while (frequencyMap.size() > k) { // if frequency of characters is more than k, shorten window and remove frequencyMap at key val pair that is the same as str.charAt(i)
        char firstChar = str.charAt(startPointer);
        frequencyMap.put(firstChar, frequencyMap.get(firstChar) - 1);
        if (frequencyMap.get(firstChar) == 0) {
          frequencyMap.remove(firstChar);
        }
        startPointer++;
      }
      maxCount = Math.max(maxCount, i - startPointer + 1);
    }

    return maxCount;
  }
}
