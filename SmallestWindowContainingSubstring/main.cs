class MinimumWindowSubstring {
  public static String findSubstring(String str, String pattern){
    int match = 0, startPointer = 0, startSubString = 0;
    int smallestSubArrayLength = str.Length + 1;
    Dictionary<char, int> patternLettersFrequency = new Dictionary<char, int>();

    for(int i = 0; i < pattern.Length; i++){
      if(patternLettersFrequency.ContainsKey(pattern[i])){
        patternLettersFrequency[pattern[i]]++;
      } else {
        patternLettersFrequency.Add(pattern[i], 1)
      }
    }

    for(int endPointer = 0; endPointer < str.Length; endPointer++){
      char currentChar = str[endPointer];
      if(patternLettersFrequency.ContainsKey(currentChar)){
        patternLettersFrequency[currentChar]--;
        if(patternLettersFrequency[currentChar] == 0){
          match++;
        }
      }

      while(match == pattern.Length){
        if(smallestSubArrayLength > endPointer - startPointer + 1){
          smallestSubArrayLength = endPointer - startPointer + 1;
          startSubString = startPointer;
        }

        char startChar = str[startPointer];
        if(patternLettersFrequency.ContainsKey(startChar)){
          if(patternLettersFrequency[startChar] == 0){
            match--;
          }
          patternLettersFrequency[startChar]++;
        }
        startPointer++;
      }
    }

    return smallestSubArrayLength > str.Length ? "" : str.Substring(startPointer, startPointer + smallestSubArrayLength);
  }
}
