// https://leetcode.com/problems/missing-number/

import java.util.HashMap;

class Solution {
    public int missingNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], 1);
        }

        for(int i=0; i<=nums.length; i++) {
            if(!map.containsKey(i))
                return i;
        }
        return 0;
    }
}

// Using these properties, the approach can be understood as::

// First find XOR all numbers in the range [1, n]
// Then XOR all elements of the array with the XOR(1, n).
// The result will be the missing number.

// 5^5 = 0, 5^0 = 5

// Java program to find the missing number 

class GfG {
    static int missingNumber( int[] arr) {
      int xor1 = 0, xor2 = 0;
     int n= arr.length+1;

      // XOR all array elements
      for (int i = 0; i < n - 1; i++) {
          xor2 ^= arr[i];
      }

      // XOR all numbers from 1 to n
      for (int i = 1; i <= n; i++) {
          xor1 ^= i;
      }

      // Missing number is the XOR of xor1 and xor2
      return xor1 ^ xor2;
  }

  public static void main(String[] args) {
      int[] arr = { 1, 2, 3, 5 };
      //int n = 5;
      System.out.println(missingNumber(arr));
  }
}