/*
  T - O(n)
  S - o(1)
  
  Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
*/

class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum){
    int[] answer = new int[2];
    int startPointer = 0;
    int endPointer = arr.length - 1;
    int currentSum = 0;

    while(startPointer < endPointer){
      currentSum = arr[startPointer] + arr[endPointer];
      if(currentSum == targetSum){
        answer[0] = startPointer;
        answer[1] = endPointer;
        break;
      } else if(currentSum > targetSum){
        endPointer--;
      } else if(currentSum < targetSum){
        startPointer++;
      }
    }
    return answer;
  }
}
