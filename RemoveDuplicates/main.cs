class RemoveDuplicates {
  public static int remove(int[] arr){
    int lastNonDuplicating = 1;

    for(int i = 1; i < arr.Length; i++){
      if(arr[lastNonDuplicating - 1] != arr[i]){
        arr[lastNonDuplicating] = arr[i];
        lastNonDuplicating++;
      }
    }

    return lastNonDuplicating;
  }
}
