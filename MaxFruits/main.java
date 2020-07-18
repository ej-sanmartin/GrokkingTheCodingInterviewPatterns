/*
  T - O(n), because we are looping through the char[] once.
  S - O(1), because the HashMap is the data structure effecting the space efficiency of this function and it is only keeping track of up to two kvp aka 2 baskets

  Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number
  of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

  You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e.,
  you will stop when you have to pick from a third fruit type.

  Write a function to return the maximum number of fruits in both the baskets.
*/

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
