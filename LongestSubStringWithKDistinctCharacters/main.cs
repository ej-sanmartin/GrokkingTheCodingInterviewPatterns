// T - O(n) | S - O(k)
 
public static int findLengthOfSubString(String str, int k){
  if(str == null || str.Length == 0 || str.Length < k){ throw new IllegalArgumentException; }

  Dictionary<char, int> frequencyDictionary = new Dictionary<char, int>();
  int startPointer = 0;
  int maxCount = 0;

  for(int i = 0; i < str.Length; i++){
    char currentChar = str[i];
    if(frequencyDictionary.ContainsKey(currentChar)){
      frequencyDictionary[currentChar]++;
    } else {
      frequencyDictionary.Add(currentChar, 1);
    }

    while(frequencyDictionary.Values.Max() > k){
      firstDictionary[str[startPointer]]--;
      if(firstDictionary[str[startPointer]] == 0){
        firstDictionary.Remove(str[startPointer]);
      }
      startPointer++;
    }
    maxCount = Math.Max(maxCount, i - startPointer + 1);
  }

  return maxCount;
}
