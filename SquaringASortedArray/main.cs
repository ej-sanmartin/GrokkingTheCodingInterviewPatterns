class SortedArraySquares {
  public int[] makeSquares(int[] arr{
    int[] squares = new int[arr.length];
    int startPointer = 0, startPointerSquared = 0, endPointerSquared = 0;
    int endPointer = arr.length - 1;
    int endIndexOfNewArray = squares.length - 1;

    while(startPointer < endPointer){
      startPointerSquared = arr[startPointer] * arr[startPointer];
      endPointerSquared = arr[endPointer] * arr[endPointer];
      if(startPointerSquared > endPointerSquared){
        squares[endIndexOfNewArray] = startPointerSquared;
        endIndexOfNewArray-;
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
