// T - O(n) | S - ()

/*
  Given an array of positive numbers and a positive number ‘S’, find the length of the
  smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if
  no such subarray exists.
*/

class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int startWindow = 0;
    int windowSum = 0;
    int subArrayLength = Integer.MAX_VALUE; // want to set to as high as possible, so first time calculating minSubArrayLength in loop is always smallest

    for(int i = 0; i < arr.length; i++){
      windowSum += arr[i]; // increase windowSum

      while(windowSum >= S){ // once windowSum is larger than S, increase startWindow until it no longer is
        subArrayLength = Math.min(subArrayLength, i - startWindow + 1); // set subArrayLength, from when sum > S to just before startWindow is at index where this is no longer true
        windowSum -= arr[startWindow];
        startWindow++;
      }
    }

    return subArrayLength;
  }
}
