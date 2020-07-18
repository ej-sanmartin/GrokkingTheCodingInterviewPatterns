import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    HashMap<Character, Integer> twoFruitBasketsCount = new HashMap<Character, Integer>();
    int startPointer = 0;
    int maxFruit = 0;

    for(int i = 0; i < arr.length; i++){
      twoFruitBasketsCount.put(arr[i], twoFruitBasketsCount.getOrDefault(arr[i], 0) + 1);

      while(twoFruitBasketsCount.size() > 2){
        twoFruitBasketsCount.put(arr[startPointer], twoFruitBasketsCount.getOrDefault(arr[startPointer], 0) - 1);
        if(twoFruitBasketsCount.get(arr[startPointer]) == 0){
          twoFruitBasketsCount.remove(arr[startPointer]);
        }
        startPointer++;
      }
      maxFruit = Math.max(maxFruit, i - startPointer + 1);
    }

    return maxFruit;
  }
}
