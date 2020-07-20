class StringPermutation {
  public static bool findPermutation(String str, String pattern){
    Dictionary<char, int> characterFrequencyDictionary = new Dictionary<char, int>();
    int startPointer = 0, match = 0;

    for(int i = 0; i < pattern.Length; i++){
      if(characterFrequencyDictionary.ContainsKey(pattern[i])){
        characterFrequencyDictionary[pattern[i]]++;
      } else {
        characterFrequencyDictionary.Add(pattern[i], 1);
      }
    }

    for(int endPointer = 0; endPointer < str.Length - 1; endPointer++){
      char currentChar = str[endPointer];
      if(characterFrequencyDictionary.ContainsKey(currentChar)){
        characterFrequencyDictionary[currentChar]--;
        math++;
      }

      if(characterFrequencyDictionary.Count == match){ return true; }

      if(endPointer >= pattern.Length - 1){
        char startCharacter = str[startPointer];
        if(characterFrequencyDictionary.ContainsKey(startCharacter)){
          if(characterFrequencyDictionary[startCharacter] == 0){
            math--;
          }
          characterFrequencyDictionary[startCharacter]++;
        }
        startPointer++;
      }
    }
    
    return false; // if this point reached, no permutation
  }
}
