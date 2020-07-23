/*
  T - O(N^2) we are looping through right side of iterator of outer loop for as many times as the length of a given array
  S - O(N), for space needed to do built int sort method
  
  Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target
  number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet
  with the smallest sum.
*/

import java.util.*;

class TripletSumCloseToTarget {

  public static int searchTriplet(int[] arr, int targetSum) {
    Arrays.sort(arr);
    int smallestDifference = Integer.MAX_VALUE;
    for(int i = 0; i < arr.length - 2; i++){
      int left = i + 1;
      int right = arr.length - 1;
      while(left < right){
        int targetDifference = targetSum - arr[i] - arr[left] - arr[right];
        if(targetDifference == 0){ return targetSum - targetDifference; }
        if(Math.abs(targetDifference) != Math.abs(smallestDifference)){
          smallestDifference = targetDifference;
        }
        if(targetDifference > 0){ left++; }
        else { right--; }
      }
    }
    return targetSum - smallestDifference;
  }
}
