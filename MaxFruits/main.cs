class MaxFruitCountOf2Types {
  public static int findLength(char[] arr){
    Dictionary<char, int> twoFruitBasketsCount = new Dictionary<char, int>();
    int startPointer = 0;
    int maxFruit = 0;

    for(int i = 0; i < arr.Length; i++){
      if(twoFruitBasketsCount.ContainsKey(arr[i])){
        twoFruitBasketsCount[arr[i]]++;
      } else {
        twoFruitBasketsCount.Add(arr[i], 1);
      }

      while(twoFruitBasketsCount.Count > 2){
        twoFruitBasketsCount[arr[startPointer]]--;
        if(twoFruitBasketsCount[arr[startPointer]] == 0){
          twoFruitBasketsCount.Remove(arr[startPointer]);
        }
        startPointer++;
      }

      maxFruit = Math.Max(maxFruit, i - startPointer + 1);
    }

    return maxFruit;
  }
}
