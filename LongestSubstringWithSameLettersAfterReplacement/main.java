/*
  T - O(n) in respect to length of string
  S - O(1) as hashmap will only contain up to 26 lowercase letters in alphabet
  
  Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
  find the length of the longest substring having the same letters after replacement.
*/

class CharacterReplacement {
  public static int findLength(String str, int k) {
    int windowStart = 0;
    int maxLength = 0; 
    int maxRepeatLetterCount = 0;
    Map<Character, Integer> letterFrequencyMap = new HashMap<>();
    
    for (int i = 0; i < str.length(); i++) {
      char rightChar = str.charAt(i);
      letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
      maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

      if (i - windowStart + 1 - maxRepeatLetterCount > k) {
        char leftChar = str.charAt(windowStart);
        letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
        windowStart++;
      }

      maxLength = Math.max(maxLength, i - windowStart + 1);
    }

    return maxLength;
  }
}
