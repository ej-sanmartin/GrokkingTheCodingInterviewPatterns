class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr){
    int currentSum = 0;
    int startPointer = 0;
    int subArrayLength = Int32.MaxValue;

    for(int i = 0; i < arr.Length; i++){
      currentSum += arr[i];

      while(currentSum >= S){
        subArrayLength = Math.Min(subArrayLength, i - startPointer + 1);
        currentSum -= arr[startPointer];
        startPointer--;
      }
    }

    return subArrayLength. == Integer.MAX_VALUE ? 0 : subArrayLength;
  }
}
