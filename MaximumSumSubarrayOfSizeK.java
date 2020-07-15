// T - O(n) | S - O(1)
/*
  Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
*/

class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    int maxSum = maxSumStartHelper(k, arr); // set maxSum to sum of subarray of arr of k length
    int windowStart = 0; // keeping track of start index of sliding window

    int windowSum = maxSum; // init window sum by setting to maxSum

    for(int i = k; i < arr.length - 1; i++){ // continue loop
      windowSum += arr[i] - arr[windowStart]; // add current index, while subtracting arr at the index of windowStart
      windowStart++;
      maxSum = Math.max(maxSum, windowSum); // set maxSum to larger of maxSum currently saved and windowSum at this iteration
    }

    return maxSum;
  }

  // helper method to setting maxSum
  // T - O(n) | S - O(1)
  public static int maxSumStartHelper(int k, int[] arr){
    int sum = 0;
    for(int i = 0; i < k; i++){ sum += arr[i]; }
    return sum;
  }
}
