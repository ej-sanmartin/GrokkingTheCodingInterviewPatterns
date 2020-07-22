class PairWithTargetSum {
  public static int[] search(int[] arr, int targetSum){
    int[] answer = new int[2];
    int startPointer = 0;
    int endPointer = arr.Length - 1;
    int currentSum;
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
