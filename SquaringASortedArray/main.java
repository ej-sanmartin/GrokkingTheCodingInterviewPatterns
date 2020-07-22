/*
  T - O(N), depends on length of array passed in
  S - O(1), only creating integer variables to keep track of different parts of function

  Given a sorted array, create a new array containing squares of all the number of the
  input array in the sorted order.
*/

class SortedArraySquares {

  public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];
    int startPointer = 0;
    int endPointer = arr.length - 1;
    int endIndexOfNewArray = squares.length - 1;
    int startPointerSquared = 0;
    int endPointerSquared = 0;

    while(startPointer < endPointer){
      startPointerSquared = arr[startPointer] * arr[startPointer];
      endPointerSquared = arr[endPointer] * arr[endPointer];
      if(startPointerSquared > endPointerSquared){
        squares[endIndexOfNewArray] = startPointerSquared;
        endIndexOfNewArray--;
        startPointer++;
      } else {
        squares[endIndexOfNewArray] = endPointerSquared;
        endIndexOfNewArray--;
        endPointer--;
      }
    }
    
    return squares;
  }
}
