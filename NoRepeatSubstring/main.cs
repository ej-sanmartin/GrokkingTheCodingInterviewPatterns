class NoRepeatSubstring {
  public static int findLength(String str){
    HashSet<char> distinctCharacter = new HashSet<char>();
    int startWindow = 0;
    int maxLength = 0;

    for(int i = 0; i < str.Length; i++){
      if(distinctCharacter.Contains(str[i])){
        distinctCharacter.Clear();
        distinctCharacter.Add(str[i]);
        startWindow = i;
      } else {
        distinctCharacter.Add(str[i]);
      }

      maxLength = Math.Max(maxLength, i - startWindow + 1);
    }

    return maxLength
  }
}
