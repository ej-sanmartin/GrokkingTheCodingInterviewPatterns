class StringAnagrams{
  public static List<int> findStringAnagrams(String str, String pattern){
    List<int> result = new List<int>();
    Dictionary<char, int> patternLettersFrequency = new Dictionary<char, int>();
    int match = 0;
    int startPointer = 0;

    for(int i = 0; i < pattern.Length; i++){
      if(patternLettersFrequency.ContainsKey(pattern[i])){
        patternLettersFrequency[pattern[i]]++;
      } else {
        patternLettersFrequency.Add(pattern[i], 1);
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

      if(match == patternLettersFrequency.Count){
        result.Add(startPointer);
      }

      if(endPointer >= pattern.Length - 1){
        char startChar = str[endPointer];
        if(patternLettersFrequency.ContainsKey(startChar)){
          if(patternLettersFrequency[startChar] == 0){
            match--;
          }
          patternLettersFrequency[startChar]++;
        }
        startPointer++;
      }
    }

    return result;
  }
}
