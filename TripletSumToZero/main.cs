class TripletSumToZero {
  public static List<List<int>> searchTriplets(int[] arr){
    Array.Sort(arr);
    List<List<int>> triplets = new List<List<int>>();

    for(int i = 0; i < arr.Length - 2; i++){
      if(i > 0 && arr[i] == arr[i - 1]){ continue; }
      searchPair(arr, -arr[i], i + 1, triplets);
    }

    return triplets;
  }

  private static void searchPair(int[] arr, int targetSum, int left, List<List<int>> triplets){
    int right = arr.Length - 1;
    while(left < right){
      int currentSum = arr[left] + arr[right];
      if(currentSum == targetSum){
        triplets.Add(new List<int>{ -targetSum, arr[left], arr[right] });
        left++;
        right--;
        while(left < right && arr[left] == arr[left - 1]){ left++; }
        while(left < right && arr[right] == arr[right + 1]){ right--; }
      } else if(currentSum > targetSum){ left++ }
      else{ right--; }
    }
  }
}
