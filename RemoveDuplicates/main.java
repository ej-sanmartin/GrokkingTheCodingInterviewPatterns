/*
  T -  O(n), since we have to loop through every element in the array
  S - O(1), since we are only ever creating the lastNonDuplicating int variable every time this function is called
  
  Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing
  the duplicates in-place return the new length of the array.
*/

class RemoveDuplicates {

  public static int remove(int[] arr) {
    int lastNonDuplicating = 1;
    for(int i = 1; i < arr.length; i++){
      if(arr[lastNonDuplicating - 1] != arr[i]){
        arr[lastNonDuplicating] = arr[i];
        lastNonDuplicating++;
      }
    }

    return lastNonDuplicating;
  }
}
