class ReplacingOnes {
  public static int findLength(int[] arr, int k){
    int maxOnesCount = 0;
    int startWindow = 0;
    int maxLength;

    for(int i = 0; i < arr.Length; i++){
      if(arr[i] == 1){ maxOnesCount++; }
      if(i - startWindow + 1 - maxOnesCount > k){
        if(arr[startWindow] == 1){ maxOnesCount--; }
        startWindow++;
      }

      maxLength = Math.Max(maxLength, i - startWindow + 1);
    }

    return maxLength;
  }
}
