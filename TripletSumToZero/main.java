/*
  T - O(N^2), the function within the for loop in the public function runs in O(N). So we are doing
              that function N number of times, N in this instance equal to length of arr
  S - O(N), required from sorting of array

  Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
*/

import java.util.*;

class TripletSumToZero {
  public static List<List<Integer>> searchTriplets(int[] arr) {
    Arrays.sort(arr);
    List<List<Integer>> triplets = new ArrayList<>();

    for(int i = 0; i < arr.length - 2; i++){
      if(i > 0 && arr[i] == arr[i - 1]){ continue; } // will skip duplicates, since sorted will keep duplicates next to each other
      searchPairs(arr, -arr[i], i + 1, triplets);
    }

    return triplets;
  }

  private static void searchPairs(int[] arr, int targetSum, int left, List<List<Integer>> triplets){
    int right = arr.length - 1;
    while(left < right){
      int currentSum = arr[left] + arr[right];
      if(currentSum == targetSum){
        triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
        left++;
        right--;
        while(left < right && arr[left] == arr[left - 1]){ left++; } // if there are duplicates, will skip over
        while(left < right && arr[right] == arr[right + 1]){ right--; } // same as comment above
      } else if(currentSum > targetSum){ right--; }
      else{ left++; }
    }
  }
}
