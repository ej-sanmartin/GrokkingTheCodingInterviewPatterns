class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr){
    int maxSum = setMaxSum(k, arr);
    int currentSum = maxSum;
    int startPointer = 0;

    for(int i = k; i < arr.Length; i++){
      currentSum = currentSum + arr[i] - arr[startPointer];
      maxSum = Math.Max(maxSum, currentSum);
      startPointer++;
    }

    return maxSum;
  }

  private static int setMaxSum(int k, int[] arr){
    int sum = 0;

    for(int i = 0; i < k; i++){
      sum += arr[i];
    }

    return sum;
  }
}
