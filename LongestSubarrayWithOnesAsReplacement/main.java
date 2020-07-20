/*
  T - O(N), we have to loop through array at least once
  S - O(1), we are only every creating three int values to keep track of things happening in the loop
  
  Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’
  0s with 1s, find the length of the longest contiguous subarray having all 1s.
*/

class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
    int maxOnesCount = 0;
    int startWindow = 0;
    int maxLength = 0;

    for(int i = 0; i < arr.length; i++){
      if(arr[i] == 1){ maxOnesCount++; }
      if(i - startWindow + 1 - maxOnesCount > k) {
        if(arr[startWindow] == 1){ maxOnesCount--; }      
        startWindow++;
      }
      maxLength = Math.max(maxLength, i - startWindow + 1);
    }

    return maxLength;
  }
}
